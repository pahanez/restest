package com.pahanez.restest.dataprovider.mock;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pahanez.restest.data.entity.Toy;
import com.pahanez.restest.dataprovider.R;
import com.pahanez.restest.dataprovider.mock.info.ToyInfo;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pindziukou on 10/11/15.
 */
public class MockData {

    private final Context mContext;
    private boolean mIsInitialized;

    private final Gson mGson = new Gson();
    private final Map<String, Toy> mToysMap = new HashMap<String, Toy>(); // <id, item>

    public MockData(Context context) {
        mContext = context;
        loadToys();

        mIsInitialized = true;
    }

    private void loadToys() {
        Type listType = new TypeToken<List<ToyInfo>>(){}.getType();
        List<ToyInfo> listOfToys = mGson.fromJson(new InputStreamReader(mContext.getResources().openRawResource(R.raw.toys_mock)), listType);

        Date currDate = new Date();
        Calendar cal = Calendar.getInstance();

        for (ToyInfo toyInfo : listOfToys) {
            Toy toy = new Toy(toyInfo.id, toyInfo.name, toyInfo.isRed);
            cal.setTime(currDate);
            cal.add(Calendar.MINUTE, (int) -toyInfo.changedTime);
            toy.setChangedTime(cal.getTimeInMillis());
            mToysMap.put(toy.getId(), toy);
        }
    }

    public boolean isInitialized() {
        if(mToysMap.isEmpty()) return false;
        return mIsInitialized;
    }

    public List<Toy> getToyList() {
        return new ArrayList<>(mToysMap.values());
    }
}
