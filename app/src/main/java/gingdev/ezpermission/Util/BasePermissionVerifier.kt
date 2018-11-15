package gingdev.ezpermission.Util

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity

import gingdev.ezpermission.Interface.EZPermissionListener

open class BasePermissionVerifier: AppCompatActivity() {

    private lateinit var activity: Activity
    private lateinit var EZPermissionListener: EZPermissionListener

    protected fun setBaseActivity(activity: Activity) {
        this.activity = activity
    }
    protected fun setBaseListener(EZPermissionListener: EZPermissionListener) {
        this.EZPermissionListener = EZPermissionListener
    }

    protected fun needRequestRuntimePermission(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
    }

    protected fun requestUnGranted(permissions: Array<String>) {
        val Ungrantedpermissions: Array<String> = FindIsPermissionUngranted(permissions)

        if (Ungrantedpermissions.size == 0) {
            permissionGranted()
            return
        }
        return ActivityCompat.requestPermissions(activity, permissions, 0)
    }

    private fun FindIsPermissionUngranted(permissions: Array<String>): Array<String> {
        var list: MutableList<String> = ArrayList()
        for (permission in permissions) {
            if (!isPermissionGranted(permission))
                list.add(permission)
        }
        return list.toTypedArray()
    }

    private fun isPermissionGranted(permission: String): Boolean {
        return ActivityCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED
    }

    protected fun RequestPermissionResult(permissions: Array<String>, grantResult: IntArray) {
        if (grantResult.size > 0) {
            for (gResult in grantResult) {
                if (gResult != PackageManager.PERMISSION_GRANTED) {
                    permissionDenied()
                    return
                }
            }
        }
        permissionGranted()
    }

    protected fun permissionGranted() {EZPermissionListener.permissionGranted()}
    protected fun permissionDenied() {EZPermissionListener.permissionDenied()}
}