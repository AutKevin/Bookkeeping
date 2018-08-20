<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
        body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
    </style>
    <link href="/${appName}/commons/jslib/hplus/css/style.min.css" rel="stylesheet">
    <link href="/${appName}/commons/jslib/hplus/css/bootstrap.min.css" rel="stylesheet">
    <link href="/${appName}/commons/jslib/hplus/css/animate.min.css" rel="stylesheet">
    <link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.css" />
    <link rel="stylesheet" href="/${appName}/commons/jslib/hplus/css/plugins/datapicker/datepicker3.css" type="text/css"></link>

    <script src="/${appName}/commons/jslib/hplus/js/jquery.min.js"></script>
    <script type="text/javascript" src="/${appName}/commons/jslib/hplus/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=paDpSLgHfu03xGBTqZvmefjRsT9y14Ty"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.js"></script>
    <script type="text/javascript" src="/${appName}/commons/jslib/hplus/js/plugins/suggest/bootstrap-suggest.min.js"></script>
    <script type="text/javascript" src="/${appName}/commons/jslib/hplus/js/plugins/datapicker/bootstrap-datepicker.js"></script>
    <script type="text/javascript" src="/${appName}/commons/jslib/CommonValue.js"></script>
    <title>路线</title>
</head>
<body class="gray-bg black-bg-gmtx">
<div class="wrapper wrapper-content ">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <div class="row">
                <div class="col-sm-4">
                    <label class="col-sm-4 control-label">
                        时间：
                    </label>
                    <div class="col-sm-8 controls">
										<span style="position: relative; z-index: 9999;">
											<input type="text" value="" class="form-control" name="time" id="time_search" tabindex="1" />
										</span>
                    </div>
                </div>
                <div class="col-sm-2">
                    <div class="input-group ">
                        <input type="text" class="form-control" id="user_search"   placeholder="选择成员" name="cateCode" tabindex="2">
                        <ul class="dropdown-menu dropdown-menu-right search_ul" role="menu">
                        </ul>
                    </div>
                </div>
                <div class="col-sm-1">
                    <button id="btn_search" type="button" class="btn btn-gmtx-define1" onclick="getGps()"  tabindex="7">
                        显示路径
                    </button>
                </div>
            </div>
        </div>
        <div class="ibox-content">
            <div id="allmap"></div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    httpurl_homePage = "/Bookkeeping"
    // 百度地图API功能
    var map = new BMap.Map("allmap",{minZoom:4,maxZoom:19});
    map.centerAndZoom(new BMap.Point(119.42,32.39), 13);
    var isFirst = true;
    function getGps(){
        map.clearOverlays();
        var time_search=$("#time_search").val();
        $.ajax({
            type: "get",
            dataType: "json",
            url: httpurl_homePage + "/HttpInfoController/getRout",
            data: {time:time_search,userId:userCode_search},
            success: function (data) {
                if(data!=null&&data.length>0){
                    list = data;
                    listLast = list.length-1;
                    // 百度地图API功能
                    map.centerAndZoom(new BMap.Point(list[0].lontitude,list[0].latitude), 15);  // 初始化地图,设置中心点坐标和地图级别
                    map.addControl(new BMap.MapTypeControl());   //添加地图类型控件

                    map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放

                    setTimeout(drawIcon,500);
                    myBeginIcon = new BMap.Icon("/${appName}/commons/images/qi.png", new BMap.Size(25,37), {imageOffset: new BMap.Size(0, 0)});//人
                    myEndIcon = new BMap.Icon("/${appName}/commons/images/zhi.png", new BMap.Size(25,37), {imageOffset: new BMap.Size(0, 0)});//人
                }
            },
            error: function (a, b, c) {

            }
        });
    }
    //var list = [{Long:106.652024,Lat:26.617221},{Long:106.652024,Lat:26.614221},{Long:106.654024,Lat:26.612221},{Long:106.657024,Lat:26.612221}];
    function drawGreenLine(i){
        polyline = new BMap.Polyline([
            new BMap.Point(list[i].lontitude,list[i].latitude),//起始点的经纬度
            new BMap.Point(list[i+1].lontitude,list[i+1].latitude)//终点的经纬度
        ], {strokeColor:"#696969",//设置颜色
            strokeWeight:4, //宽度
            strokeOpacity:0.9});//透明度
        map.addOverlay(polyline);
    }

    function drawIcon(){
        var carMk;
        if(carMk){
            map.removeOverlay(carMk);
        }
        carMk2 = new BMap.Marker(
            new BMap.Point(list[0].lontitude,list[0].latitude),//起始点的经纬度
            {icon:myBeginIcon});
        map.addOverlay(carMk2);

        carMk = new BMap.Marker(
            new BMap.Point(list[listLast].lontitude,list[listLast].latitude),//终点的经纬度
            {icon:myEndIcon});
        map.addOverlay(carMk);

        for(var i=0;i<list.length-1;i++){
            drawGreenLine(i);
        }

    }
    function dateInit(dom){
        $('#'+dom).datepicker({
            autoclose: true, //自动关闭
            beforeShowDay: $.noop,    //在显示日期之前调用的函数
            calendarWeeks: false,     //是否显示今年是第几周
            clearBtn: false,          //显示清除按钮
            daysOfWeekDisabled: [],   //星期几不可选
            endDate: Infinity,        //日历结束日期
            forceParse: true,         //是否强制转换不符合格式的字符串
            format: 'yyyy-mm-dd',     //日期格式
            keyboardNavigation: true, //是否显示箭头导航
            language: 'cn',           //语言
            minViewMode: 0,
            orientation: "vertical",      //方向
            rtl: false,
            startDate: -Infinity,     //日历开始日期
            startView: 0,             //开始显示
            todayBtn: true,          //今天按钮
            todayHighlight: true,    //今天高亮
            weekStart: 0              //星期几是开始
        });
    }
    $(function(){
        userCode_search = '';
        $("#user_search").bsSuggest('init', {
            clearable: true,
            url: "/${appName}/manager/userController/getAllUserByUid",
            showBtn: false,
            idField: "id",    //id字段
            keyField: "name",   //key字段
            effectiveFields: ["name"],   //使用字段
            effectiveFieldsAlias: {"name":"名称"},    //字段别名,title显示
        }).on("onSetSelectValue",function(e, keyword) {    //选择时
            userCode_search = keyword.id;
        }).on("onUnsetSelectValue",function(e) {
            userCode_search = '';
        });

        $.fn.datepicker.dates['cn'] = {   //切换为中文显示
            days: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
            daysShort: ["日", "一", "二", "三", "四", "五", "六", "七"],
            daysMin: ["日", "一", "二", "三", "四", "五", "六", "七"],
            months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            monthsShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            today: "今天",
            clear: "清除"
        };
        dateInit('time_search');

        $('#time_search').datepicker('setDate',getNowFormatDate());
        getGps();
    });

    $(function(){
        $('.search_ul').css({left:'0px',width:'100%'});
    });
</script>
</html>


