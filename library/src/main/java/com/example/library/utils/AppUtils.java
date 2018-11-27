package com.example.library.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;

import java.util.List;

public class AppUtils
{

	private AppUtils() {
		/* cannot be instantiated */
		throw new UnsupportedOperationException("cannot be instantiated");

	}

	/**
	 * 获取应用程序名称
	 */
	public static String getAppName(Context context)
	{
		try
		{
			PackageManager packageManager = context.getPackageManager();
			PackageInfo packageInfo = packageManager.getPackageInfo(
					context.getPackageName(), 0);
			int labelRes = packageInfo.applicationInfo.labelRes;
			return context.getResources().getString(labelRes);
		}  catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * [获取应用程序版本名称信息]
	 * 
	 * @param context
	 * @return 当前应用的版本名称
	 */
	public static String getVersionName(Context context)
	{
		try
		{
			PackageManager packageManager = context.getPackageManager();
			PackageInfo packageInfo = packageManager.getPackageInfo(
					context.getPackageName(), 0);
			return packageInfo.versionName;

		} catch (PackageManager.NameNotFoundException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 获取版本号
	 *
	 * @param context
	 * @return
	 */
	public static int getVersionCode(Context context) {
		PackageManager pManager = context.getPackageManager();
		PackageInfo packageInfo = null;
		try {
			packageInfo = pManager.getPackageInfo(context.getPackageName(), 0);

		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
		}
		return packageInfo.versionCode;
	}
	/**
	 * 安装App
	 *
	 * @param context
	 * @param filePath
	 * @return
	 */
	public static boolean installNormal(Context context, String filePath) {
		Intent i = new Intent(Intent.ACTION_VIEW);
		java.io.File file = new java.io.File(filePath);
		if (file == null || !file.exists() || !file.isFile() || file.length() <= 0) {
			return false;
		}

		i.setDataAndType(Uri.parse("file://" + filePath), "application/vnd.android.package-archive");
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(i);
		return true;
	}

	/**
	 * 卸载App
	 *
	 * @param context
	 * @param packageName
	 * @return
	 */
	public static boolean uninstallNormal(Context context, String packageName) {
		if (packageName == null || packageName.length() == 0) {
			return false;
		}

		Intent i = new Intent(Intent.ACTION_DELETE, Uri.parse(new StringBuilder().append("package:")
				.append(packageName).toString()));
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(i);
		return true;
	}
	/**
	 * packName  应用的包名
	 * 返回值
	 */
	public static boolean isAppAlive(Context context, String packageName){
		ActivityManager activityManager =
				(ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
		List<ActivityManager.RunningAppProcessInfo> processInfos
				= activityManager.getRunningAppProcesses();
		for(int i = 0; i < processInfos.size(); i++){
			if(processInfos.get(i).processName.equals(packageName)){
				Log.i("NotificationLaunch",
						String.format("the %s is running, isAppAlive return true", packageName));
				return true;
			}
		}
		Log.i("NotificationLaunch",
				String.format("the %s is not running, isAppAlive return false", packageName));
		return false;
	}
	public static int getAppSatus(Context context, String pageName) {

		ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		List<ActivityManager.RunningTaskInfo> list = am.getRunningTasks(20);

		//判断程序是否在栈顶
		if (list.get(0).topActivity.getPackageName().equals(pageName)) {
			return 1;
		} else {
			//判断程序是否在栈里
			for (ActivityManager.RunningTaskInfo info : list) {
				if (info.topActivity.getPackageName().equals(pageName)) {
					return 2;
				}
			}
			return 3;//栈里找不到，返回3
		}
	}

}