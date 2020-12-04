package com.aricsun.boot.launch.model;

import java.util.List;

/**
 * GsonFormat插件示例 快捷键alt+s 记不住的话，双击shift搜索gson
 * @author AricSun
 * @date 2020.12.04 21:21
 */
public class LiveRecord {
    /**
     * roomlist : [{"id":3443750,"enabled":true},{"id":892762,"enabled":true}]
     * feature : 2
     * clip_length_future : 10
     * clip_length_past : 20
     * cutting_mode : 2
     * cutting_number : 1828
     * timing_stream_retry : 6000
     * timing_stream_connect : 5000
     * timing_danmaku_retry : 15000
     * timing_check_interval : 300
     * timing_watchdog_timeout : 10000
     * cookie : _uuid=11DA070B-15D5-3890-55BC-4ADF75CD618720049infoc; buvid3=F8BAB30A-5C34-4BC1-8461-BA79F93073BD155803infoc; sid=84d0he73; LIVE_BUVID=AUTO1115844371304700; CURRENT_FNVAL=16; rpdid=|()kY~lR~km0J'ul)RRR|u)m; CURRENT_QUALITY=116; bp_t_offset_241794521=404093673083102833; DedeUserID=28608788; DedeUserID__ckMd5=09313ae109cdd32f; SESSDATA=e4360a7d%2C1608478122%2C14b79*61; bili_jct=8975a620ba44712bb075a91cd8c2dfad; LIVE_PLAYER_TYPE=1; GIFT_BLOCK_COOKIE=GIFT_BLOCK_COOKIE; bp_video_offset_28608788=408246519909789251; Hm_lvt_8a6e55dbd2870f0f5bc9194cddf32a02=1593775256,1593787550,1593889532,1593892172; Hm_lpvt_8a6e55dbd2870f0f5bc9194cddf32a02=1593892172; F_S_T_28608788=1; bp_t_offset_28608788=408481484686489204; _dfcaptcha=944f9cd159d55c7be69425472c25f70d; PVID=33
     * record_danmaku : true
     * record_danmaku_raw : false
     * record_danmaku_sc : true
     * record_danmaku_gift : false
     * record_danmaku_guard : false
     * live_api_host : https://api.live.bilibili.com
     * record_filename_format : {roomid}-{name}/{date}-{time}-{title}-{random}.flv
     * clip_filename_format : {roomid}-{name}/剪辑片段-{roomid}-{date}-{time}-{title}.flv
     */

    private int feature;
    private int clip_length_future;
    private int clip_length_past;
    private int cutting_mode;
    private int cutting_number;
    private int timing_stream_retry;
    private int timing_stream_connect;
    private int timing_danmaku_retry;
    private int timing_check_interval;
    private int timing_watchdog_timeout;
    private String cookie;
    private boolean record_danmaku;
    private boolean record_danmaku_raw;
    private boolean record_danmaku_sc;
    private boolean record_danmaku_gift;
    private boolean record_danmaku_guard;
    private String live_api_host;
    private String record_filename_format;
    private String clip_filename_format;
    private List<RoomlistBean> roomlist;

    public int getFeature() {
        return feature;
    }

    public void setFeature(int feature) {
        this.feature = feature;
    }

    public int getClip_length_future() {
        return clip_length_future;
    }

    public void setClip_length_future(int clip_length_future) {
        this.clip_length_future = clip_length_future;
    }

    public int getClip_length_past() {
        return clip_length_past;
    }

    public void setClip_length_past(int clip_length_past) {
        this.clip_length_past = clip_length_past;
    }

    public int getCutting_mode() {
        return cutting_mode;
    }

    public void setCutting_mode(int cutting_mode) {
        this.cutting_mode = cutting_mode;
    }

    public int getCutting_number() {
        return cutting_number;
    }

    public void setCutting_number(int cutting_number) {
        this.cutting_number = cutting_number;
    }

    public int getTiming_stream_retry() {
        return timing_stream_retry;
    }

    public void setTiming_stream_retry(int timing_stream_retry) {
        this.timing_stream_retry = timing_stream_retry;
    }

    public int getTiming_stream_connect() {
        return timing_stream_connect;
    }

    public void setTiming_stream_connect(int timing_stream_connect) {
        this.timing_stream_connect = timing_stream_connect;
    }

    public int getTiming_danmaku_retry() {
        return timing_danmaku_retry;
    }

    public void setTiming_danmaku_retry(int timing_danmaku_retry) {
        this.timing_danmaku_retry = timing_danmaku_retry;
    }

    public int getTiming_check_interval() {
        return timing_check_interval;
    }

    public void setTiming_check_interval(int timing_check_interval) {
        this.timing_check_interval = timing_check_interval;
    }

    public int getTiming_watchdog_timeout() {
        return timing_watchdog_timeout;
    }

    public void setTiming_watchdog_timeout(int timing_watchdog_timeout) {
        this.timing_watchdog_timeout = timing_watchdog_timeout;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public boolean isRecord_danmaku() {
        return record_danmaku;
    }

    public void setRecord_danmaku(boolean record_danmaku) {
        this.record_danmaku = record_danmaku;
    }

    public boolean isRecord_danmaku_raw() {
        return record_danmaku_raw;
    }

    public void setRecord_danmaku_raw(boolean record_danmaku_raw) {
        this.record_danmaku_raw = record_danmaku_raw;
    }

    public boolean isRecord_danmaku_sc() {
        return record_danmaku_sc;
    }

    public void setRecord_danmaku_sc(boolean record_danmaku_sc) {
        this.record_danmaku_sc = record_danmaku_sc;
    }

    public boolean isRecord_danmaku_gift() {
        return record_danmaku_gift;
    }

    public void setRecord_danmaku_gift(boolean record_danmaku_gift) {
        this.record_danmaku_gift = record_danmaku_gift;
    }

    public boolean isRecord_danmaku_guard() {
        return record_danmaku_guard;
    }

    public void setRecord_danmaku_guard(boolean record_danmaku_guard) {
        this.record_danmaku_guard = record_danmaku_guard;
    }

    public String getLive_api_host() {
        return live_api_host;
    }

    public void setLive_api_host(String live_api_host) {
        this.live_api_host = live_api_host;
    }

    public String getRecord_filename_format() {
        return record_filename_format;
    }

    public void setRecord_filename_format(String record_filename_format) {
        this.record_filename_format = record_filename_format;
    }

    public String getClip_filename_format() {
        return clip_filename_format;
    }

    public void setClip_filename_format(String clip_filename_format) {
        this.clip_filename_format = clip_filename_format;
    }

    public List<RoomlistBean> getRoomlist() {
        return roomlist;
    }

    public void setRoomlist(List<RoomlistBean> roomlist) {
        this.roomlist = roomlist;
    }

    public static class RoomlistBean {
        /**
         * id : 3443750
         * enabled : true
         */

        private int id;
        private boolean enabled;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }
}
