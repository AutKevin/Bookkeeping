<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
        body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
    </style>
    <link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.css" />
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=paDpSLgHfu03xGBTqZvmefjRsT9y14Ty"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.js"></script>
    <script src="/${appName}/commons/jslib/hplus/js/jquery.min.js"></script>
    <title>实时定位</title>
</head>
<body>

<div id="allmap"></div>
</body>
<script type="text/javascript">
    httpurl_homePage = "/Bookkeeping"
    // 百度地图API功能
    var map = new BMap.Map("allmap",{minZoom:4,maxZoom:19});
    map.centerAndZoom(new BMap.Point(119.42,32.39), 13);
    map.enableScrollWheelZoom(true);
    var isFirst = true;
    function getGps(){
        $.ajax({
            type: "get",
            dataType: "json",
            url: httpurl_homePage + "/HttpInfoController/getGPSForWeb",
            data: {},
            success: function (data) {
                map.clearOverlays();
                for(var i = 0; i < data.length; i++){    //遍历list数据
                    var json = data[i];    //ai代表list中的某一项
                    var lon= json.lontitude;
                    var lat = json.latitude;
                    var flag = json.userFlag;
                    var point = new BMap.Point(lon, lat);
                    if(isFirst){
                        map.centerAndZoom(point,15);
                        isFirst = false;
                    }

                    var content = '<div style="margin:0;line-height:20px;padding:2px;">' +
                        '地址:'+(json.addr==null?"无":json.addr)+ '<br/>描述：'+(json.locationdescribe==null?"无":json.locationdescribe)+'。'
                        + '<br/>更新时间：'+(json.time==null?"无":json.time.substring(0, json.time.length - 2))
                        + '<br/>定位方式：'+ getNetLocaType(json.networkLocationType) +'</div>';
                    var marker = new BMap.Marker(point); //创建marker对象
                    //marker.enableDragging(false); //marker可拖拽
                    openInfo(map,marker,flag,content);
                    map.addOverlay(marker); //在地图中添加marke
                }
            },
            error: function (a, b, c) {

            }
        });
    }

    function openInfo(map,marker,flag,content){
        //创建检索信息窗口对象
        var searchInfoWindow = new BMapLib.SearchInfoWindow(map, content, {
            title  : flag,      //标题
            width  : 290,             //宽度
            height : 95,              //高度
            panel  : "panel",         //检索结果面板
            enableAutoPan : true,     //自动平移
            searchTypes   :[
                BMAPLIB_TAB_SEARCH,   //周边检索
                BMAPLIB_TAB_TO_HERE,  //到这里去
                BMAPLIB_TAB_FROM_HERE //从这里出发
            ]
        });

        marker.addEventListener("click", function(e){
            searchInfoWindow.open(marker);
        });
    }

    function getNetLocaType(networkLocationType){
        switch(networkLocationType){
            case 'wf':
                return "wifi";
                break;
            case 'cl':
                return  "手机";
                break;
            case 'll':
                return  "GPS";
                break;
            default:
                return  "无";
        }
    }
    $(function(){
        getGps();
        window.setInterval("getGps()",1000*59);
    });
</script>
</html>


