package com.zaakman.lib.data;


import com.zaakman.lib.beans.StorageBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ZaakMan on 2017/8/5.
 */

public class ReleaseScanDataHelper {

    private static ReleaseScanDataHelper sReleaseScanDataHelper = null;

    private HashMap<String, List<StorageBean>> mMap = new HashMap<>();

    private HashMap<String, Integer> mCountMap = new HashMap<>();

    private List<String> mStrings = new ArrayList<>();

    private ReleaseScanDataHelper() {

    }

    public static ReleaseScanDataHelper getInstance() {
        if (sReleaseScanDataHelper == null) {
            sReleaseScanDataHelper = new ReleaseScanDataHelper();
        }
        return sReleaseScanDataHelper;
    }

    public void putData(String flagCode, List<StorageBean> list) {
        mMap.put(flagCode, list);
        for (String str : mStrings) {
            if (flagCode.equals(str)) return;
        }
        mStrings.add(flagCode);
    }

    public List<StorageBean> getData(String flagCode) {
        return mMap.get(flagCode);
    }

    public void initData(List<StorageBean> list) {
        mCountMap.clear();
        mMap.clear();
        mStrings.clear();
        for (StorageBean bean : list) {
            List<StorageBean> tempList = getData(bean.flagCode);
            if (tempList == null) {
                tempList = new ArrayList<>();
                tempList.add(bean);
                putData(bean.flagCode, tempList);
            } else {
                tempList.add(bean);
            }

            if (bean.isCheck) {
                setScanCount(bean.flagCode, getScanCount(bean.flagCode) + 1);
            }
        }
    }

    public List<StorageBean> isContainData(String code, boolean isScan) {
        List<StorageBean> returnList = new ArrayList<>();
        for (String flagCode : mStrings) {
            List<StorageBean> list = getData(flagCode);
            if (list == null) return null;
            for (StorageBean bean : list) {
                if (code.equals(bean.bztm)) {
                    bean.isCheck = isScan;
                    returnList.addAll(list);
                    return returnList;
                }
            }
        }
        return null;
    }

    public List<String> getFlagCodes() {
        return mStrings;
    }

    public void delete(String flagCode) {
        mMap.remove(flagCode);
        String deleteItem = null;
        for (String temp : mStrings) {
            if (temp.equals(flagCode)) deleteItem = temp;
        }
        mStrings.remove(deleteItem);
    }

    public void setScanCount(String flagCode, Integer scanCount) {
        mCountMap.put(flagCode, scanCount);
    }

    public Integer getScanCount(String flagCode) {
        if (mCountMap.get(flagCode) == null) return 0;
        return mCountMap.get(flagCode);
    }

    public void clear() {
        mStrings.clear();
        mMap.clear();
        mCountMap.clear();
    }

}
