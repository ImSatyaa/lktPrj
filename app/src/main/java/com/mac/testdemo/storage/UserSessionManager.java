package com.mac.testdemo.storage;

import android.content.Context;
import android.content.SharedPreferences;

public class UserSessionManager {

    private static UserSessionManager gardenSharedPrfs;
    private SharedPreferences appSharedPrefs;
    private SharedPreferences.Editor prefsEditor;

    private static final String sharedprfstag="Rental";
    private static final String prf_login_status="loginstatus";
    private static final String prf_loginid="loginid";
    private static final String prf_imei_no="imei";
    private static final String prf_user_detail="userdetail";
    private static final String offline_timestamp="2016-09-22 07:00:00";



    private UserSessionManager(Context context) {
        this.appSharedPrefs = context.getSharedPreferences(sharedprfstag, Context.MODE_PRIVATE);
        this.prefsEditor = appSharedPrefs.edit();
    }

    public static UserSessionManager getsharedprefInstance(Context con) {
        if (gardenSharedPrfs == null)
            gardenSharedPrfs = new UserSessionManager(con);
        return gardenSharedPrfs;
    }

    public SharedPreferences getAppSharedPrefs() {
        return appSharedPrefs;
    }

    public void setAppSharedPrefs(SharedPreferences appSharedPrefs) {
        this.appSharedPrefs = appSharedPrefs;
    }

    public SharedPreferences.Editor getPrefsEditor() {
        return prefsEditor;
    }

    public void Commit() {
        prefsEditor.commit();
    }

    public void setBaseURL(String url) {
        this.prefsEditor = appSharedPrefs.edit();
        prefsEditor.putString("base_url", url);
        prefsEditor.commit();
    }


    public void setLoggedIn(boolean status){
        this.prefsEditor=appSharedPrefs.edit();
        prefsEditor.putBoolean("isLoggedIn",status);
        prefsEditor.commit();
    }

    public boolean isLoggedIn(){
        return appSharedPrefs.getBoolean("isLoggedIn",false);
    }

    public void setUserDetail(String selfDetails){
        this.prefsEditor=appSharedPrefs.edit();
        prefsEditor.putString("user_details",selfDetails);
        prefsEditor.commit();
    }

   /* public UserDataObject getUserDetail(){
        String userData=appSharedPrefs.getString("user_details","");
        UserDataObject userDataObject=new Gson().fromJson(userData,UserDataObject.class);
        return userDataObject;
    }*/

    public void setTaskType(String selfDetails){
        this.prefsEditor=appSharedPrefs.edit();
        prefsEditor.putString("task_type",selfDetails);
        prefsEditor.commit();
    }

    /*public List<TaskType> getTaskType(){
        String userData=appSharedPrefs.getString("task_type","");
        Type token=new TypeToken<List<TaskType>>(){}.getType();
        List<TaskType> userDataObject=new Gson().fromJson(userData,token);
        return userDataObject;
    }*/

    public void setUserList(String selfDetails){
        this.prefsEditor=appSharedPrefs.edit();
        prefsEditor.putString("user_list",selfDetails);
        prefsEditor.commit();
    }



   /* public LoginResponseHelper getLoginResponse(){
        String userData=appSharedPrefs.getString("login_res","");
        return new Gson().fromJson(userData, LoginResponseHelper.class);
    }*/

    public void setLoginResponse(String selfDetails){
        this.prefsEditor=appSharedPrefs.edit();
        prefsEditor.putString("login_res",selfDetails);
        prefsEditor.commit();
    }



    /*public List<UserList> getUserList(){
        String userData=appSharedPrefs.getString("user_list","");
        Type token=new TypeToken<List<UserList>>(){}.getType();
        List<UserList> userDataObject=new Gson().fromJson(userData,token);
        return userDataObject;
    }*/

    public void setdepartmentId(String deptId){
        this.prefsEditor=appSharedPrefs.edit();
        prefsEditor.putString("dept_Id",deptId);
        prefsEditor.commit();
    }
    public String getdepartmentId(){
        return  appSharedPrefs.getString("dept_Id","");
    }

    public void setsbuId(String sbuId){
        this.prefsEditor=appSharedPrefs.edit();
        prefsEditor.putString("sbu_Id",sbuId);
        prefsEditor.commit();
    }
    public String getsbuId(){
        return  appSharedPrefs.getString("sbu_Id","");
    }

    public void setLocId(String locId){
        this.prefsEditor=appSharedPrefs.edit();
        prefsEditor.putString("loc_Id",locId);
        prefsEditor.commit();
    }
    public String getLocId(){
        return  appSharedPrefs.getString("loc_Id","");
    }

    public void setTokenID(String locId){
        this.prefsEditor=appSharedPrefs.edit();
        prefsEditor.putString("token_id",locId);
        prefsEditor.commit();
    }
    public String getTokenID(){
        return  appSharedPrefs.getString("token_id","");
    }


    public void setSpinnerStatus(boolean status){
        this.prefsEditor=appSharedPrefs.edit();
        prefsEditor.putBoolean("isSet",status);
        prefsEditor.commit();
    }
    public boolean getSpinnerStatus() {
        return appSharedPrefs.getBoolean("isSet",false);
    }

    public String getFCMDeviceId() {
        return appSharedPrefs.getString("fcmDeviceId", "");
    }

    public void setFCMDeviceId(String fcmDeviceId) {
        this.prefsEditor = appSharedPrefs.edit();
        prefsEditor.putString("fcmDeviceId", fcmDeviceId);
        prefsEditor.commit();
    }


    public void setRole(boolean  role){
        this.prefsEditor = appSharedPrefs.edit();
        prefsEditor.putBoolean("super_user", role);
        prefsEditor.commit();
    }

    public boolean isSuperUser(){
        return appSharedPrefs.getBoolean("super_user", false);
    }


    public void setNoti(String noti){
        this.prefsEditor=appSharedPrefs.edit();
        prefsEditor.putString("noti",noti);
        prefsEditor.commit();
    }
    public String getNoti(){
        return  appSharedPrefs.getString("noti","");
    }


    public void setUpcommingStatus(boolean status){
        this.prefsEditor=appSharedPrefs.edit();
        prefsEditor.putBoolean("up_com",status);
        prefsEditor.commit();
    }
    public boolean getUpcommingStatusStatus()
    {
        return appSharedPrefs.getBoolean("up_com",false);
    }
    public void setOverDueStatus(boolean status){
        this.prefsEditor=appSharedPrefs.edit();
        prefsEditor.putBoolean("over_due",status);
        prefsEditor.commit();
    }
    public boolean getOverDueStatus()
    {
        return appSharedPrefs.getBoolean("over_due",false);
    }
    public void setPendingStatus(boolean status){
        this.prefsEditor=appSharedPrefs.edit();
        prefsEditor.putBoolean("pending",status);
        prefsEditor.commit();
    }
    public boolean getPendingStatus()
    {
        return appSharedPrefs.getBoolean("pending",false);
    }


    public String getFCMToken() {
        return appSharedPrefs.getString("fcmDeviceId", "");
    }

    public void setFCMToken(String fcmDeviceId) {
        this.prefsEditor = appSharedPrefs.edit();
        prefsEditor.putString("fcmDeviceId", fcmDeviceId);
        prefsEditor.commit();
    }
}
