package gingdev.ezpermission.Util

import gingdev.ezpermission.Model.PermissionList

class PermissionListMaker {
    private val pl = PermissionList()
    /**
        Get all permissions of permission group
    **/

    fun getLocationPermissionList() : Array<String> {
        return arrayOf(
                pl.accessFineLocation,
                pl.accessCorseLocation
        )
    }

    fun getStoragePermissionList() : Array<String> {
        return arrayOf(
                pl.readExternalStorage,
                pl.writeExternalStorage
        )
    }

    fun getSMSPermissionList() : Array<String> {
        return arrayOf(
                pl.sendSMS,
                pl.receiveSMS,
                pl.readSMS,
                pl.receiveWapPush,
                pl.receiveMMS
        )
    }

    fun getSensorPermissionList() : Array<String> {
        return arrayOf(
                pl.bodySensors
        )
    }

    fun getPhonePermissionList() : Array<String> {
        return arrayOf(
                pl.readPhoneState,
                pl.callPhone,
                pl.readCallLog,
                pl.writeCallLog,
                pl.addVoiceMail,
                pl.useSip,
                pl.processOutGoingCalls
        )
    }

    fun getMicroPhonePsermissionList() : Array<String> {
        return arrayOf(
                pl.recordAudio
        )
    }

    fun getContactsPermissionList() : Array<String> {
        return arrayOf(
                pl.readContacts,
                pl.writeContacts,
                pl.getAccounts
        )
    }

    fun getCameraPermissionList() : Array<String> {
        return arrayOf(
                pl.camera
        )
    }

    fun getCalendarPermissionList() : Array<String> {
        return arrayOf(
                pl.readCalendar,
                pl.writeCalendar
        )
    }

}