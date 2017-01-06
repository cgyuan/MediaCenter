
package com.rockchips.mediacenter.data;

import java.util.Arrays;

import momo.cn.edu.fjnu.androidutils.data.CommonValues;
import momo.cn.edu.fjnu.androidutils.utils.PackageUtils;
/**
 * @author GaoFei
 * 一些数据常量
 */
public class ConstData {
	
	public static final String DB_NAME = "mediacenter.db";
	public static final int DB_VERSION = 1;
	//public static final String DB_DIRECTORY = Environment.getExternalStorageDirectory() + "/" + PackageUtils.getPackageName();
	public static final String DB_DIRECTORY = CommonValues.application.getFilesDir() + "/" + PackageUtils.getPackageName();
	public static final String CACHE_IMAGE_DIRECTORY = DB_DIRECTORY + "/" + "imgcache";
	public static final String NETWORK_DEVICE_MOUNT_DIR = "/data" + "/mediacenter_networkdevice";
	public class NFS{
		//挂载路径
		public static final String MOUNT_PATH = "/mnt/sdcard/nfs";
		public static final String MOUNT_COMMAND = "busybox mount -t nfs -o nolock 172.16.21.123:/home/szc/nfsTest /mnt/sdcard/nfs";
		public static final String UNMOUNT_COMMAND = "umount /mnt/sdcard/nfs";
	}
	
	/**
	 * 内部SD卡目录
	 */
	public static final String INNER_SD_DIR = "/mnt/sdcard";
	
	/**
	 * 挂载结果
	 * @author GaoFei
	 *
	 */
	public interface MOUNT_RESULT{
		public static final String MOUNT_SUCC = "1";
		public static final String MOUNT_FAIL = "0";
	}
	
	/**
	 * 卸载结果
	 * @author GaoFei
	 *
	 */
	public interface UMOUNT_RESULT{
		public static final String UMOUNT_SUCC = "1";
		public static final String UMOUNT_FAIL = "0";
	
	}
	/**
	 * 网络设备类型
	 * @author GaoFei
	 *
	 */
	public interface NetWorkDeviceType{
		int DEVICE_ALL = -1;
		int DEVICE_NFS = 0;
		int DEVICE_SMB = 1;
	}
	
	public interface IntentKey{
		String NFS_INFO = "nfs_info";
		String EXTRAL_LOCAL_DEVICE = "extral_local_device";
		String EXTRAL_MEDIA_TYPE = "extral_media_type";
		//String IS_INTERNAL_PLAYER = "is_internal_palyer";
		//String CURRENT_INDEX = "current_index";
		String EXTRA_IS_SEARCH = "extra_is_search";
		String EXTRA_DEVICE_TYPE = "extra_device_type";
		String EXTRA_NFS_INFO = "extra_nfs_info";
		String EXTRA_SAMBA_INFO = "extra_samba_info";
		String EXTRA_DEVICE_PATH = "extra_device_path";
        /**
         * 获取媒体列表的key键
         */
        public static final String MEDIA_INFO_LIST = "MEDIA_INFO_LIST";

        public static final String IS_INTERNAL_PLAYER = "IS_INTERNAL_PLAYER";

        public static final String MEDIALIST_ID = "MEDIALIST_ID";

        public static final String MEDIALIST_PACKAGE_COUNT = "MEDIALIST_PACKAGE_COUNT";

        public static final String MEDIALIST_PACKAGE_ORDERID = "MEDIALIST_PACKAGE_ORDERID";
        
        public static final String IS_MIRROR_ON = "IS_MIRROR_ON";

        /**
         * 唯一标示的Key键
         */
        public static final String UNIQ = "UNIQ";

        /**
         * 播放器与MCS建立绑定时，返回给MCS的Sender端唯一标示的Key键
         */
        public static final String SENDER_UNIQ_PLAYER_TO_MCS = "SENDER_UNIQ_PLAYER_TO_MCS";

        /**
         * 定位播放位置的Key键
         */
        public static final String SEEK_POS = "SEEK_POS";

        /**
         * 报告错误信息的Key键
         */
        public static final String ERROR_INFO = "ERROR_INFO";

        /**
         * 传递上一个、下一个、上一页、下一页媒体请求的Key键
         */
        public static final String MEDIA_REQUEST_TYPE = "MEDIA_REQUEST_TYPE";

        /**
         * 当前播放器所播放的URL
         */
        public static final String CURRENT_PLAY_URL = "CURRENT_PLAY_URL";

        /**
         * 传递下线设备ID的Key键
         */
        public static final String DEVICE_ID = "DEVICE_ID";

        /**
         * 传递当前索引的Key键
         */
        public static final String CURRENT_INDEX = "CURRENT_INDEX";

        /**
         * 传递媒体的播放总长度
         */
        public static final String MEDIA_DURATION = "MEDIA_DURATION";

        /**
         * 传输Data-url
         */
        public static final String MEDIA_DATA = "MEDIA_DATA";

        // search intent begin

        public static final String SEARCH_DATA = "data";

        public static final String SEARCH_DISPLAYNAME = "_display_name";

        public static final String SEARCH_THUMBURL = "thumbnail_url";

        public static final String SEARCH_TITLE = "title";

        public static final String SEARCH_ALBUM = "album";

        public static final String SEARCH_ARTIST = "artist";

        public static final String SEARCH_MEDIATYPE = "media_type";

        // search intent end        

        /**
         * 传输一个MediaInfo,作为需要显示的对象 比如传入一个设备信息，要求显示该设备信息 传入一个文件夹信息，要求显示文件夹下的内容
         */
        public static final String CURRENTMEDIAINFO = "CURRENTMEDIAINFO";

        public static final String ISSHARE = "ISSHARE";

        /**
         * 为了解决BroadcastReceiver生命周期较短的问题，使用IntentService处理业务逻辑
         */
        public static final String RECEIVER_TO_SERVICE_ACTION = "RECEIVER_TO_SERVICE_ACTION";

        /**
         * 传输U盘挂载的路径
         */
        public static final String MOUNTED_PATH = "MOUNTED_PATH";

        /**
         * 传递音量调节类型
         */
        public static final String VOLUME_ADJUST_TYPE = "VOLUME_ADJUST_TYPE";

        /**
         * 传递音量设置的值
         */
        public static final String VOLUME_SET_VALUE = "VOLUME_SET_VALUE";

        /**
         * 云相册展示类型
         */
        public static final String CLOUD_DISPLAY_TYPE = "CLOUD_DISPLAY_TYPE";

        public static final String IS_REUSE_AUDIOPLAYER = "IS_REUSE_AUDIOPLAYER";

        /**
         * 云相册跳转类型
         */
        public static final String CLOUD_LOGIN_JUMP_TYPE = "CLOUD_LOGIN_JUMP_TYPE";
    
	}
	
	
	public interface SharedKey{
		/**NFS网络路径*/
		public String NFS_INFOS = "nfs_net_infos";
		/**Smb网络路径*/
		public String SMB_INFOS = "smb_infos";
	}
	
	public interface ViewTags{
		public int FILE_LIST_BACK_FLAG = 1;
		public int FILE_LIST_LOCK_KEY = 2;
		public int FILE_LIST_BACK_PROC_FLAG = 1;
	}
	
	public interface BooleanValue{
		public String TRUE = "true";
		public String FALSE = "false";
	}
	
	 // 音频格式后缀
    public static final String[] AUDIO_SUFFIX = {"mp3", "wma", "amr", "aac", "wav", "wave", "ogg", "mka", "ac3", "m4a", "ra", "flac",
        "ape", "mpa", "aif", "aiff", "at3p", "au", "snd", "dts", "rmi", "mid", "mp1", "mp2", "pcm", "lpcm", "l16",
        "ram"};
    
    // 视频格式后缀
    public static final String[] VIDEO_SUFFIX = {"avi", "wmv", "mp4", "rmvb", "kkv", "3gp", "ts", "mpeg", "mpg", "mkv", "m3u8", "mov",
        "m2ts", "flv", "m2t", "mts", "vob", "dat", "m4v", "asf", "f4v", "3g2", "m1v", "m2v", "tp", "trp", "m2p", "rm",
        "avc", "dv", "divx", "mjpg", "mjpeg", "mpe", "mp2p", "mp2t", "mpg2", "mpeg2", "m4p", "mp4ps", "ogm", "hdmov",
        "qt", "iso", "webm"};
    
    // 图片格式后缀
    public static final String[] IMAGE_SUFFIX = {"bmp", "gif", "png", "jpg", "jpeg", "jpe", "tiff", "tif", "pcd", "qti", "qtf", "qtif",
        "ico", "pnm", "ppm"};
    
    // 字幕格式后缀
    public static final String[] SUBTITLE_SUFFIX = {"ass", "lrc", "srt", "smi", "sub", "txt", "pgs", "dvb", "dvd"};
	
    /**
     * 排序
     */
    static{
    	Arrays.sort(AUDIO_SUFFIX);
    	Arrays.sort(VIDEO_SUFFIX);
    	Arrays.sort(IMAGE_SUFFIX);
    	Arrays.sort(SUBTITLE_SUFFIX);
    }
	
    /**
     * 媒体文件类型
     * @author GaoFei
     *
     */
    public static final class MediaType
    {
        public static final int UNKNOWN_TYPE = -1;

        public static final int BASE = 0;

        public static final int DEVICE = BASE + 1;

        public static final int FOLDER = BASE + 2;

        public static final int VIDEO = BASE + 4;

        public static final int AUDIO = BASE + 6;

        public static final int SUBTITLE = BASE + 7;

        public static final int IMAGE = BASE + 8;

        public static final int MEDIA = BASE + 9;

        // t00181037 add
        public static final int VIDEOFOLDER = BASE + 10;

        public static final int AUDIOFOLDER = BASE + 11;

        public static final int IMAGEFOLDER = BASE + 12;

        // cloud
        // t00181037 add
        public static final int CLOUDMUSIC = BASE + 13;

        public static final int CLOUDPHOTO = BASE + 14;

        public static final int CLOUDFRIEND = BASE + 15;

        public static String getMediaTypeName(int type)
        {
            String strRet = "UNKNOWN_TYPE";
            switch (type)
            {
                case DEVICE:
                    strRet = "DEVICE";
                    break;

                case FOLDER:
                    strRet = "FOLDER";
                    break;

                case AUDIO:
                    strRet = "AUDIO";
                    break;

                case VIDEO:
                    strRet = "VIDEO";
                    break;

                case IMAGE:
                    strRet = "IMAGE";
                    break;
                case SUBTITLE:
                    strRet = "SUBTITLE";
                    break;

                case VIDEOFOLDER:
                    strRet = "VIDEOFOLDER";
                    break;

                case AUDIOFOLDER:
                    strRet = "AUDIOFOLDER";
                    break;

                case IMAGEFOLDER:
                    strRet = "IMAGEFOLDER";
                    break;

                case CLOUDPHOTO:
                    strRet = "CLOUDPHOTO";
                    break;

                case CLOUDMUSIC:
                    strRet = "CLOUDMUSIC";
                    break;

                case CLOUDFRIEND:
                    strRet = "CLOUDFRIEND";
                    break;
                case UNKNOWN_TYPE:
                    strRet = "UNKNOWN_TYPE";
                    break;

                default:
                    strRet = "UNKNOWN_TYPE";
                    break;
            }

            return strRet;
        }
    }
    
    
    /**
     * 设备类型
     * @author GaoFei
     *
     */
    public static final class DeviceType
    {
    	/**
    	 * NFS设备
    	 * GaoFei Add
    	 */
    	public static final int DEVICE_TYPE_NFS = 2001;
    	
    	
    	/**
    	 * SMB设备
    	 * GaoFei Add
    	 */
    	public static final int DEVICE_TYPE_SMB = 2002;
    	/**内部存储设备*/
    	public static final int DEVICE_TYPE_INTERNEL_STORAGE = -13;
    	
        /**
         * SD盘设备类型
         */
        public static final int DEVICE_TYPE_SD = -12;

        /**
         * U盘设备类型
         */
        public static final int DEVICE_TYPE_U = -11;

        /**
         * 预留 0-10为特殊设备
         */
        public static final int DEVICE_TYPE_OTHER_PRODUCT = 0;

        // 0,1,2 indicate rockchips settings(cellphone, stb, pad)
        public static final int DEVICE_TYPE_HW_CELLPHONE = 1;

        public static final int DEVICE_TYPE_HW_STB = 2;

        public static final int DEVICE_TYPE_HW_PAD = 3;

        // 搜索项
        public static final int DEVICE_TYPE_SEARCH = 4;

        /**
         * normal DMS设备类型
         */
        public static final int DEVICE_TYPE_DMS = 20;

        // add by zwx143228 加上收藏夹展示
        /**
         * 收藏夹类型
         * */
        public static final int DEVICE_TYPE_FAVORITE = 21;

        /**
         * /** 云设备
         */
        // modified by c00226539 云相册要放到固定设备之后，网络设备之前
        public static final int DEVICE_TYPE_CLOUD = -10;

        /**
         * 云设备
         */
        public static final int DEVICE_TYPE_HUAWEI_CLOUD = 1001;

        /**
         * QQ云设备
         */
        public static final int DEVICE_TYPE_QQ_CLOUD = 1003;

        /**
         * DropBox云设备
         */
        public static final int DEVICE_TYPE_DROPBOX_CLOUD = 1004;

        /**
         * 天翼云设备
         */
        public static final int DEVICE_TYPE_TIANYI_CLOUD = 1002;

        /*
         * 未知设备类型
         */
        public static final int DEVICE_TYPE_UNKNOWN = -1;

        // 设备类型相关------结束
        /**
         * 根据 type 判断是否为外设 <功能详细描述>
         * @param type
         * @return
         * @see [类、类#方法、类#成员]
         */
        public static boolean isExternalStorage(int type)
        {
            switch (type)
            {
                case DEVICE_TYPE_SD:
                case DEVICE_TYPE_U:
                    return true;

                case DEVICE_TYPE_DMS:
                case DEVICE_TYPE_HW_CELLPHONE:
                case DEVICE_TYPE_HW_PAD:
                case DEVICE_TYPE_HW_STB:
                case DEVICE_TYPE_OTHER_PRODUCT:
                case DEVICE_TYPE_CLOUD:
                    return false;

                default:
                    break;
            }

            return false;
        }

        /**
         * 根据 type 判断是否网络设备 <功能详细描述>
         * @param type
         * @return
         * @see [类、类#方法、类#成员]
         */
        public static boolean isDLNADevice(int type)
        {
            switch (type)
            {
                case DEVICE_TYPE_SD:
                case DEVICE_TYPE_U:
                case DEVICE_TYPE_CLOUD:
                    return false;

                case DEVICE_TYPE_DMS:
                case DEVICE_TYPE_HW_CELLPHONE:
                case DEVICE_TYPE_HW_PAD:
                case DEVICE_TYPE_HW_STB:
                case DEVICE_TYPE_OTHER_PRODUCT:

                    return true;

                default:
                    break;
            }

            return false;
        }

        public static boolean isHWDevice(int type)
        {
            switch (type)
            {
                case DEVICE_TYPE_HW_CELLPHONE:
                case DEVICE_TYPE_HW_PAD:
                case DEVICE_TYPE_HW_STB:
                    return true;

                default:
                    break;
            }

            return false;
        }

        /**
         * 根据 type 判断是否本地设备 <功能详细描述>
         * @param type
         * @return
         * @see [类、类#方法、类#成员]
         */
        public static boolean isLocalDevice(int type)
        {
            switch (type)
            {
                case DEVICE_TYPE_SD:
                case DEVICE_TYPE_U:
                    return true;

                default:
                    break;
            }

            return false;
        }

    }
    
    public interface BroadCastMsg{
    	String DEVICE_UP = "com.rockchip.mediacenter.deviceup";
    	String DEVICE_DOWN = "com.rockchip.mediacenter.devicedown";
    	String NFS_MOUNT = "com.rockchip.mediacenter.nfsmount";
    	String SAMBA_MOUNT = "com.rockchip.mediacenter.sambamount";
    	String REFRESH_NETWORK_DEVICE = "com.rockchip.mediacenter.refresh_network_device";
    	String REFRESH_ALL_DEVICES = "com.rockchip.mediacenter.refresh_all_devices";
    	String CHECK_NETWORK = "com.rockchip.mediacenter.check_network";
    }
    
    public enum EBrowerType
    {
        ORDER_TYPE_NONE, ORDER_TYPE_TIME, ORDER_TYPE_CHARACTER, ORDER_TYPE_FOLDER, ORDER_TYPE_ALBUM, ORDER_TYPE_ARTIST
    }
    
    public enum ESearchType
    {
        SEARCH_TYPE_ALL, SEARCH_TYPE_BY_DEVICE
    }
    
    
    public static final class MCSMessage
    {

        // 不可用消息标示
        public static final int MSG_MCS_UNKNOWN = -1;

        // Player注册所需消息
        public static final int MSG_REGISTER_CALLBACK = 0;

        public static final int MSG_UNREGISTER_CALLBACK = 1;

        // player向Sender端发送的报告
        public static final int MSG_REPORT_ERROR = 2;

        public static final int MSG_REQUEST_MEDIA_LIST = 3;

        // 播控消息
        public static final int MSG_SET_MEDIA_DATA = 4;

        public static final int MSG_APPEND_MEDIA_DATA = 5;

        public static final int MSG_PLAY = 6;

        public static final int MSG_PAUSE = 7;

        public static final int MSG_SEEK = 8;

        public static final int MSG_STOP = 9;

        public static final int MSG_PLAYER_LIST = 10;

        // 设备下线消息
        public static final int MSG_DEVICE_DOWN = 11;

        public static final int MSG_DURATION = 12;

        // 当前曲目
        public static final int MSG_CURRENT_PLAYING_PROGRAM = 13;

        // 新需求，DMC调节音量的消息
        public static final int MSG_ADJUST_VOLUME = 14;

        public static final int MSG_GET_TIME = 777888;

        public static final int MSG_UPDATE_TIME = 777889;

    }
    
    public static final class DeleteModeState
    {
        public static final int DELETE_MODE_STATE_NONE = 0;

        public static final int DELETE_MODE_STATE_UNSELECTED = 1;

        public static final int DELETE_MODE_STATE_SELECTED = 2;
    }
    
    public interface TaskExecuteResult{
    	int SUCCESS = 1;
    	int FAILED = 0;
    }
}
