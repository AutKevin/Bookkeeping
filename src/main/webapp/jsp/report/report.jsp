<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>天消费报表</title>
    <meta name="keywords" content="天消费报表">
    <meta name="description" content="天消费报表">
    <link href="/${appName}/commons/jslib/hplus/css/style.min.css" rel="stylesheet">
    <link href="/${appName}/commons/jslib/hplus/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/${appName}/commons/jslib/hplus/css/plugins/datapicker/datepicker3.css" type="text/css"></link>
    <link rel="stylesheet" href="/${appName}/commons/jslib/hplus/css/plugins/sweetalert/sweetalert.css" type="text/css"></link>
    <script src="/${appName}/commons/jslib/hplus/js/jquery.min.js"></script>
    <script type="text/javascript" src="/${appName}/commons/jslib/hplus/js/bootstrap.min.js"></script>
    <script src="/${appName}/commons/echarts.js"></script>
    <script src="/${appName}/commons/jslib/CommonValue.js"></script>
    <script type="text/javascript" src="/${appName}/commons/jslib/hplus/js/plugins/datapicker/bootstrap-datepicker.js"></script>
    <script type="text/javascript" src="/${appName}/commons/jslib/hplus/js/plugins/sweetalert/sweetalert.min.js"></script>
    <script>
        function dateInit(dom){
            $('#'+dom).datepicker({
                autoclose: true, //自动关闭
                beforeShowDay: $.noop,    //在显示日期之前调用的函数
                calendarWeeks: false,     //是否显示今年是第几周
                clearBtn: false,          //显示清除按钮
                daysOfWeekDisabled: [],   //星期几不可选
                endDate: Infinity,        //日历结束日期
                forceParse: true,         //是否强制转换不符合格式的字符串
                format: 'yyyy-mm',     //日期格式
                keyboardNavigation: true, //是否显示箭头导航
                language: 'cn',           //语言
                orientation: "vertical",      //方向
                rtl: false,
                startDate: -Infinity,     //日历开始日期
                todayBtn: false,          //今天按钮
                todayHighlight: false,    //今天高亮
                weekStart: 0,              //星期几是开始
                /*startView: 0,             //开始显示
                minViewMode: 0,*/

                startView: 'months',
                maxViewMode:'years',
                minViewMode:'months',
                onSelect: function(dateText){
                    getPie(dateText);
                }
            });
        }
        var sum = 0;   //金额汇总
        function getPie(time){
            /*获取种类*/
            $.ajax({
                url: '/${appName}/manager/reportController/getUsedCate',
                type: 'post',
                async: 'true',
                cache: false,
                data: {time:time},
                dataType: 'json',
                success: function (catedate) {
                    if (!isNull(catedate)) {

                        /*获取数据*/
                        $.ajax({
                            url: '/${appName}/manager/reportController/getCatePie',
                            type: 'post',
                            async: 'true',
                            cache: false,
                            data: {time:time},
                            dataType: 'json',
                            success: function (piedata) {
                                if (!isNull(piedata)) {
                                    for(var money in piedata){
                                        sum += parseFloat(piedata[money].value);
                                    }

                                    var dom = document.getElementById("container");
                                    var myChart = echarts.init(dom);
                                    var app = {};
                                    option = null;
                                    option = {
                                        title: {
                                            text: time+'月度消费类型分析',
                                            subtext: "消费总计"+sum.toFixed(2)+"元   单位:元",
                                            x: 'center'
                                        },
                                        tooltip: {
                                            trigger: 'item',
                                            formatter: "{a} <br/>{b} : {c} ({d}%)"
                                        },
                                        legend: {
                                            orient: 'vertical',
                                            left: 'left',
                                            data: catedate
                                        },
                                        series: [
                                            {
                                                name: '消费类型',
                                                type: 'pie',
                                                radius: '55%',
                                                center: ['50%', '60%'],
                                                data: piedata,
                                                itemStyle: {
                                                    emphasis: {
                                                        shadowBlur: 10,
                                                        shadowOffsetX: 0,
                                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                                    }
                                                }
                                            }
                                        ]
                                    };
                                    ;
                                    if (option && typeof option === "object") {
                                        myChart.setOption(option, true);
                                    }

                                } else {
                                    swal({
                                        title: "系统提示",
                                        text: "数据获取失败",
                                        type: "warning"
                                    }, function () {

                                    });
                                }
                            },
                            error: function (aa, ee, rr) {
                                swal({
                                    title: "系统提示",
                                    text: "请求服务器失败,清稍候再试",
                                    type: "warning"
                                }, function () {
                                });
                            }
                        });
                        /**/
                    } else {
                        swal({
                            title: "系统提示",
                            text: "该月暂无数据",
                            type: "warning"
                        }, function () {

                        });
                    }
                },
                error: function (aa, ee, rr) {
                    swal({
                        title: "系统提示",
                        text: "请求服务器失败,清稍候再试",
                        type: "warning"
                    }, function () {
                    });
                }
            });
        }

        $(function () {
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
            $('#time_search').datepicker('setDate',getNowFormatMonth());
        });

        function search(){
            sum = 0;
            var time = $("#time_search").val();
            if(isNull(time)){
                swal({
                    title: "系统提示",
                    text: "未选择月份,显示数据为至今所有数据",
                    type: "warning"
                }, function () {
                });
            }
            getPie(time);
        }
    </script>
</head>
<body class="gray-bg black-bg-gmtx">
<div class="wrapper wrapper-content ">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <div class="row">
                <div class="col-sm-12">
                    <label class="col-sm-2 control-label">
                    </label>
                    <div class="col-sm-4">
                        <span style="position: relative; z-index: 9999;">
                            <input type="text" value="" class="form-control" name="time" placeholder="请输入月份"
                                   id="time_search" tabindex="1"/>
                        </span>
                    </div>
                    <div class="col-sm-6">
                        <button id="btn_search" type="button" class="btn btn-gmtx-define1" onclick="search()"  tabindex="7">
                            搜索
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <div class="ibox-content">
            <div id="container" style="height: 80%;width:90%"></div>
        </div>
    </div>
</div>

<script>
    //判断为空
    function isNull(variable1) {
        if (variable1 == null || variable1 == undefined || variable1 == '') {
            return true;
        }
    }

    $(function () {
        getPie(getNowFormatMonth());   //初始化
    });
</script>
</body>
</html>
