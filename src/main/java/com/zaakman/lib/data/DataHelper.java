package com.zaakman.lib.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.zaakman.lib.beans.StorageBean;
import com.zaakman.lib.orm.DaoMaster;
import com.zaakman.lib.orm.DaoSession;
import com.zaakman.lib.orm.StorageBeanDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by ZaakMan on 2017/8/1.
 */

public class DataHelper {

    public static final String KEY_TOKEN = "token";

    public static final String KEY_LOGIN_NAME = "login_name";

    public static final String KEY_EXPIRATION_TIME = "expirationTime";

    public static final String KEY_CARRIER = "carrier";

    public static final String KEY_CAR_NUM = "car_num";

    public static final String KEY_CARRY_WAY = "carry_way";

    public static final String KEY_CAR_GROUP = "car_group";

    public static final String KEY_RELEASE_FINISH = "release_finish";

    public static final String KEY_AUTO_BINDING = "auto_binding";

    private Map<String,Object> mMap = new HashMap<>();

    private static DataHelper sDataHelper = null;

    private DaoSession mDaoSession = null;

    private Context mContext = null;

    private DataHelper(Context context) {
        this.mContext = context;
    }


    public static DataHelper getInstance(Context context) {
        if (sDataHelper == null) {
            sDataHelper = new DataHelper(context);
        }
        return sDataHelper;
    }

    public void save(String key, String value) {
        SharedPreferences share = getSP();
        share.edit().putString(key, value).commit();
    }

    public void save(String key, boolean value) {
        SharedPreferences share = getSP();
        share.edit().putBoolean(key, value).commit();
    }

    public String restore(String key, String defaultValue) {
        SharedPreferences share = getSP();
        return share.getString(key, defaultValue);
    }

    public boolean restoreBoolean(String key, boolean defaultValue) {
        SharedPreferences share = getSP();
        return share.getBoolean(key, defaultValue);
    }

    public void delete(String key) {
        SharedPreferences share = getSP();
        share.edit().remove(key).commit();
    }

    public void save(String key, long value) {
        SharedPreferences share = getSP();
        share.edit().putLong(key, value).commit();
    }

    public long restore(String key, long defaultValue) {
        SharedPreferences share = getSP();
        return share.getLong(key, defaultValue);
    }

    public boolean restore(String key, boolean defaultValue) {
        SharedPreferences share = getSP();
        return share.getBoolean(key, defaultValue);
    }

    private SharedPreferences getSP() {
        SharedPreferences share = mContext.getSharedPreferences(mContext.getPackageName(), Context.MODE_PRIVATE);
        return share;
    }

    public void clear() {
        getSP().edit().clear().commit();
    }

    private StorageBeanDao getStorageBeanDao() {
        return getDaoSession().getStorageBeanDao();
    }

    private DaoSession getDaoSession() {
        if (mDaoSession == null) {
            mDaoSession = DaoMaster.newDevSession(mContext, "holike.db");
        }
        return mDaoSession;
    }

    public long insertStorageBean(StorageBean bean) {
        return getStorageBeanDao().insert(bean);
    }

    public void updateStorageBean(StorageBean bean) {
        getStorageBeanDao().update(bean);
    }

    public List<StorageBean> getAllStorageBean() {
        return getStorageBeanDao().loadAll();
    }

    public void deleteAllStorageBean() {
        getStorageBeanDao().deleteAll();
    }

    public void save(String key,Object obj){
        mMap.put(key,obj);
    }

    public Object get(String key){
        return mMap.remove(key);
    }
}
