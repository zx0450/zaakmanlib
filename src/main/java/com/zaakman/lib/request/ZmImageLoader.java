package com.zaakman.lib.request;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.v4.util.LruCache;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;
import com.bumptech.glide.Glide;

/**
 * Created by ZaakMan on 2017/9/14.
 */

public class ZmImageLoader {

    private static ImageLoader mLoader = null;

    public static void Init() {
        if (ZmRequest.GetRequestQueue() == null){
            throw new NullPointerException("Not Call ZmRequest.Init() Before ZmImageLoader.Init() !");
        }
        mLoader = new ImageLoader(ZmRequest.GetRequestQueue(),new BitmapCache());
    }

    public static void Load(String url,ImageView view,int defaultId, int failedId){
//        ImageLoader.ImageListener listener = ImageLoader.getImageListener(view,defaultId,failedId);
//        mLoader.get(url,listener);
        Context context = view.getContext();
        Glide.with(context).load(url).placeholder(defaultId).error(failedId).into(view);
    }

   static class BitmapCache implements ImageLoader.ImageCache {

        private LruCache<String, Bitmap> mCache;

        public BitmapCache() {
            int maxSize = 10 * 1024 * 1024;
            mCache = new LruCache<String, Bitmap>(maxSize) {
                @Override
                protected int sizeOf(String key, Bitmap bitmap) {
                    return bitmap.getRowBytes() * bitmap.getHeight();
                }
            };
        }

        @Override
        public Bitmap getBitmap(String url) {
            return mCache.get(url);
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            mCache.put(url, bitmap);
        }

    }

}
