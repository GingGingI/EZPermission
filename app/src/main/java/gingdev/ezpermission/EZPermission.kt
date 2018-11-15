package gingdev.ezpermission

import android.app.Activity
import android.content.Context
import android.util.Log
import gingdev.ezpermission.Interface.EZPermissionListener
import gingdev.ezpermission.Util.BasePermissionVerifier

class EZPermission : BasePermissionVerifier{

    private var permissions: Array<String>? = null

    constructor()

    constructor(activity: Activity, permissions: Array<String>, EZPermissionListener: EZPermissionListener ) {
        setBaseActivity(activity)
        this.permissions = permissions
        setBaseListener(EZPermissionListener)
    }

    fun setActivity(activity: Activity) {
        setBaseActivity(activity)
    }
    fun setPermissionList(permissions: Array<String>) {
        this.permissions = permissions
    }
    fun setEZPermissionListener(EZPermissionListener: EZPermissionListener) {
        setBaseListener(EZPermissionListener)
    }

    fun RequestPermission() {
        if (permissions == null) {
            Log.e("Permissions", "Not Exist")
            return
        }
        if (!needRequestRuntimePermission()) {
            permissionGranted()
            return
        }
        requestUnGranted(permissions!!)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        RequestPermissionResult(permissions, grantResults)
    }
}