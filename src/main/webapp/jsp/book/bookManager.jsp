<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>记账簿</title>

		<meta name="keywords" content="记账簿">
		<meta name="description" content="记账簿">
		<link href="/${appName}/commons/css/qy-style.css" rel="stylesheet">
		<link href="/${appName}/commons/jslib/hplus/css/bootstrap.min.css" rel="stylesheet">
		<link href="/${appName}/commons/jslib/hplus/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
		<link href="/${appName}/commons/jslib/hplus/css/animate.min.css" rel="stylesheet">
		<link href="/${appName}/commons/jslib/hplus/css/style.min.css" rel="stylesheet">
		<link href="/${appName}/commons/jslib/hplus/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
		<link rel="stylesheet" href="/${appName}/commons/jslib/hplus/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" type="text/css"></link>
		<link rel="stylesheet" href="/${appName}/commons/jslib/hplus/css/plugins/sweetalert/sweetalert.css" type="text/css"></link>
		<link rel="stylesheet" href="/${appName}/commons/jslib/hplus/css/plugins/datapicker/datepicker3.css" type="text/css"></link>
		<style type="text/css">
		<!--
			.control-label{line-height: 34px;}
		-->
		</style>
	</head>

	<body class="gray-bg black-bg-gmtx">
		<div class="wrapper wrapper-content ">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<div class="row">
								<div class="col-sm-8">
									<label class="col-sm-3 control-label">
										消费时间：
									</label>
									<div class="col-sm-4 controls">
										<span style="position: relative; z-index: 9999;">
											<input type="text" value="" class="form-control" name="time" id="time_search_start" tabindex="1" />
										</span>
									</div>
									<div class="col-sm-1 controls">
										-
									</div>
									<div class="col-sm-4 controls">
										<span style="position: relative; z-index: 9999;">
										<div class="input-group ">
											<input type="text" value="" class="form-control" name="time" id="time_search_end" tabindex="2" />
										</div>
										</span>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="col-sm-12 controls">
										<input type="text" class="form-control" placeholder="消费详情" id="remark_search" tabindex="3">
									</div>
								</div>

							</div>
							<br/>
							<div class="row">
								<div class="col-sm-8">
									<label class="col-sm-3 control-label">
										消费金额：
									</label>
									<div class="col-sm-4 controls">
										<input type="text" value="" class="form-control" name="money" id="money_search_start" tabindex="4" />
									</div>
									<div class="col-sm-1 controls">
									-
									</div>
									<div class="col-sm-4 controls">
									  <input type="text" value="" class="form-control" name="money" placeholder="" id="money_search_end" tabindex="5" />
									</div>
								</div>
								<div class="col-sm-2">
									<div class="input-group ">
										<input type="text" class="form-control" id="cateCode_search"   placeholder="请选择消费类型" name="cateCode" tabindex="6">
										<ul class="dropdown-menu dropdown-menu-right search_ul" role="menu">
										</ul>
									</div>
								</div>
								<div class="col-sm-1">
									<button id="btn_search" type="button" class="btn btn-gmtx-define1" onclick="search()"  tabindex="7">
										搜索
									</button>
								</div>
								<div class="col-sm-1">
									<button class="btn btn-gmtx-define1" onclick="javascript:reset()" id="btn_reset">
										重置
									</button>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-1 col-md-offset-1">
									<button class="btn btn-gmtx-define1" data-toggle="modal" href="#addwin" data-keyboard="true" data-backdrop="false" id="btn_add">
										新增
									</button>
								</div>
							</div>
						</div>
						<div class="ibox-content">
							<h3><span class="label label-default">本月消费金额<span id="countMoney"></span>，上月消费总额<span id="preCountMoney"></span></span></h3>
							<table id="table">
							</table>
						</div>
					</div>
				</div>
		<!-- 添加窗口 -->
		<div class="modal fade" id="addwin">
			<div class="modal-dialog" style="width: 500px">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="addwinlable">
							记账
						</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<form method="post" class="form-horizontal" id="addform">
								<div class="form-group">
									<label class="col-sm-3 control-label">
										消费类型：
									</label>
									<div class="col-sm-8 controls">
										<div class="input-group ">
											<%--下拉提示框--%>
											<input type="text" class="form-control" id="cateCode_add" name="cateCode" tabindex="11">
											<ul class="dropdown-menu dropdown-menu-right search_ul" role="menu">
											</ul>

										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">
										消费金额：
									</label>
									<div class="col-sm-8 controls">
										<input type="text" value="" class="form-control" name="money" id="money_add" tabindex="12" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">
										备注信息：
									</label>
									<div class="col-sm-8 controls">
										<input type="text" value="" class="form-control" name="remark" id="remark_add" tabindex="13" />
									</div>
								</div>
								<%--<div class="form-group">
									<label class="col-sm-3 control-label">
										消费时间：
									</label>
									<div class="col-sm-8 controls" style="position:relative">
										<span style="position: relative; z-index: 9999;">
											<input type="text" value="" class="form-control" name="time" id="time_add" tabindex="14" />
										</span>
									</div>
								</div>--%>
								<div class="form-group">
									<div class="controls">
										<button type="submit" class="btn btn-gmtx-define1 center-block" tabindex="15">
											添加
										</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 修改窗口 -->
		<div class="modal fade" id="upwin">
			<div class="modal-dialog" style="width: 500px">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="editwinlable">
							记账
						</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<form method="post" class="form-horizontal" id="upform">
								<div class="form-group">
									<input type="text" value="" style="display:none" hidden id="id_up"/>
									<label class="col-sm-3 control-label">
										消费类型：
									</label>
									<div class="col-sm-8 controls">
										<div class="input-group ">
											<%--下拉提示框--%>
											<input type="text" class="form-control" id="cateCode_up" name="cateCode" tabindex="21">
											<ul class="dropdown-menu dropdown-menu-right search_ul" role="menu">
											</ul>

										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">
										消费金额：
									</label>
									<div class="col-sm-8 controls">
										<input type="text" value="" class="form-control" name="money" id="money_up" tabindex="22" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">
										备注信息：
									</label>
									<div class="col-sm-8 controls">
										<input type="text" value="" class="form-control" name="remark" id="remark_up" tabindex="23" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">
										消费时间：
									</label>
									<div class="col-sm-8 controls" style="position:relative">
										<span style="position: relative; z-index: 9999;">
											<input type="text" value="" class="form-control" name="time" id="time_up" tabindex="24" />
										</span>
									</div>
								</div>
								<div class="form-group">
									<div class="controls">
										<button type="submit" class="btn btn-gmtx-define1 center-block" tabindex="25">
											修改
										</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- jQuery -->
		<script src="/${appName}/commons/jslib/hplus/js/jquery.min.js"></script>
		<script src="/${appName}/commons/jslib/hplus/js/jquery-ui-1.10.4.min.js"></script>
		<script src="/${appName}/commons/jslib/hplus/js/plugins/validate/jquery.validate.min.js"></script>
		<script src="/${appName}/commons/jslib/hplus/js/plugins/validate/messages_zh.min.js"></script>
		<script src="/${appName}/commons/jslib/CommonValue.js"></script>

		<script src="/${appName}/commons/jslib/hplus/js/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="/${appName}/commons/jslib/hplus/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="/${appName}/commons/jslib/hplus/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
		<script type="text/javascript" src="/${appName}/commons/jslib/hplus/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
		<script type="text/javascript" src="/${appName}/commons/jslib/hplus/js/plugins/sweetalert/sweetalert.min.js"></script>
    	<script type="text/javascript" src="/${appName}/commons/jslib/hplus/js/plugins/suggest/bootstrap-suggest.min.js"></script>
    	<script type="text/javascript" src="/${appName}/commons/jslib/hplus/js/content.min.js"></script>
		<script type="text/javascript" src="/${appName}/commons/jslib/hplus/js/plugins/datapicker/bootstrap-datepicker.js"></script>
		<script type="text/javascript" src="/${appName}/commons/jslib/CommonValue.js"></script>
		<script src="js/plugins/layer/laydate/laydate.js"></script>
		<script type="text/javascript">
		//判断为空
		function isNull(variable1){
			if (variable1 == null || variable1 == undefined || variable1 == '') {
				return true;
			}
		}
		var cate_code_add ='';
        var cate_code_up ='';
        var cateCode_search ='';
	/**share---*/
	/*验证表单提交表单*/
	function vform(dom,func){
		$("#"+dom).validate({
				rules : {
                    cateCode : {
						required : true,
						maxlength: 50
					},
                    money:{
						required : true,
						maxlength: 50,
                        number:true
					},
                    remark:{
						required : true,
					},
                    time:{
						required : true,
                        date:true
					}
				},
				messages : {
                    cateCode : {
						required : "请选择类别",
						maxlength: "参数名过长"
					},
                    money:{
						required: "请输入金额",
						maxlength: "参数名过长",
                        number:"请输入数字"
					},
                    remark:{
						required: "请输入备注信息",
					},
                    time:{
						required: "请选择日期",
                        date:"日期格式错误"
					}
				},
				submitHandler : function() {
					func();
				}
		});
	}
	//将datepicker初始化为年月日
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
	/*
	* 获取本月和上月金额
	* */
	function getCount(){
	    /*获取本月消费金额*/
        $.ajax({
            url:'/${appName}/manager/bookController/getCountMoney',
            type:'post',
            async:'true',
            cache:false,
            data:{},
            dataType:'json',
            success: function(data){
				$("#countMoney").html(data/100);
            },
            error: function (aa, ee, rr) {
                swal({
                    title: "系统提示",
                    text: "请求本月交易金额服务器失败,清稍候再试",
                    type: "warning"
                });
            }
        });
		/*获取上月消费金额*/
        $.ajax({
            url:'/${appName}/manager/bookController/getPreCountMoney',
            type:'post',
            async:'true',
            cache:false,
            data:{},
            dataType:'json',
            success: function(data){
                $("#preCountMoney").html(data/100);
            },
            error: function (aa, ee, rr) {
                swal({
                    title: "系统提示",
                    text: "请求本月交易金额服务器失败,清稍候再试",
                    type: "warning"
                });
            }
        });
	}


	/*---share end**/
	$(function(){
        vform('addform',addBook);
        vform('upform',upBook);
        getCount();
        $.fn.datepicker.dates['cn'] = {   //切换为中文显示
            days: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
            daysShort: ["日", "一", "二", "三", "四", "五", "六", "七"],
            daysMin: ["日", "一", "二", "三", "四", "五", "六", "七"],
            months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            monthsShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            today: "今天",
            clear: "清除"
        };

        //dateInit('time_add');
        //dateInit('time_up');
        dateInit('time_search_start');
        dateInit('time_search_end');

        //$('#time_add').datetimepicker('setDate',getNowFormatDate());

        $("#cateCode_add").bsSuggest('init', {
            clearable: true,
            url: "/${appName}/manager/CommonController/getAllCate",
            showBtn: false,
            idField: "cate_code",    //id字段
            keyField: "cate_name",   //key字段
            effectiveFields: ["cate_name"],   //使用字段
            effectiveFieldsAlias: {"cate_name":"类别"},    //字段别名,title显示
        }).on("onSetSelectValue",function(e, keyword) {    //选择时
            cate_code_add = keyword.id;
        }).on("onUnsetSelectValue",function(e) {
            cate_code_add = '';
        });
        $("#cateCode_up").bsSuggest('init', {
            clearable: true,
            url: "/${appName}/manager/CommonController/getAllCate",
            showBtn: false,
            idField: "cate_code",    //id字段
            keyField: "cate_name",   //key字段
            effectiveFields: ["cate_name"],   //使用字段
            effectiveFieldsAlias: {"cate_name":"类别"},    //字段别名,title显示
        }).on("onSetSelectValue",function(e, keyword) {    //选择时
            cate_code_up = keyword.id;
        }).on("onUnsetSelectValue",function(e) {
            cate_code_up = '';
        });
        $("#cateCode_search").bsSuggest('init', {
            clearable: true,
            url: "/${appName}/manager/CommonController/getAllCate",
            showBtn: false,
            idField: "cate_code",    //id字段
            keyField: "cate_name",   //key字段
            effectiveFields: ["cate_name"],   //使用字段
            effectiveFieldsAlias: {"cate_name":"类别"},    //字段别名,title显示
        }).on("onSetSelectValue",function(e, keyword) {    //选择时
            cateCode_search = keyword.id;
        }).on("onUnsetSelectValue",function(e) {
            cateCode_search = '';
        });

		var $table = $('#table');
	    $table.bootstrapTable({
	    url: "/${appName}/manager/bookController/getAllBook",
	    method: 'post',
		contentType: "application/x-www-form-urlencoded",
	    dataType: "json",
	    pagination: true, //分页
        sidePagination: "server", //服务端处理分页
        pageList: [5, 10, 25 ,50],
	    pageSize: 10,
	    pageNumber:1,
	    //toolbar:"#tb",
	    singleSelect: false,
	    queryParamsType : "limit",
	    queryParams: function queryParams(params) {   //设置查询参数
          var param = {
            pageNo: params.offset/params.limit+1,  //offset为数据开始索引,转换为显示当前页
            pageSize: params.limit  //页面大小
          };
          console.info(params);
          console.info(param);
          return param;
        },
	    cache: false,
	    //data-locale: "zh-CN", //表格汉化
	    //search: true, //显示搜索框
        columns: [
                {
                    checkbox: true
                },
                {
                    title: '消费类型',
                    field: 'cate_name',
                    valign: 'middle'
                },
                {
                    title: '消费金额',
                    field: 'money',
                    valign: 'middle',
                    formatter:function(value,row,index){
                        if(!isNaN(value)){   //是数字
							return value/100;
						}
                    }
                },
                {
                    title: '备注',
                    field: 'remark',
                    valign: 'middle'
                },
				{
					title: '记录来源',
					field: 'user_name',
					valign: 'middle'
				},
                {
                    title: '消费时间',
                    field: 'time',
                    valign: 'middle',
                    formatter:function(value,row,index){
                        return value.substr(0,value.length-2);
                    }
                },
                {
                    title: '操作',
                    field: '',
                    formatter:function(value,row,index){
                        var u = '<a href="#" class="btn btn-gmtx-define1" onclick="editBook(\''+ row.id +'\',\''+row.time+'\')">修改</a> ';
                        var d = '<a href="#" class="btn btn-gmtx-define1" onclick="delBook(\''+ row.id +'\')">删除</a> ';
                        return u+d;
                  	 }
                }
            ]
	      });
      });
      /**------添加账单------*/
      function addBook(){
      	var cateCode = cate_code_add;
      	var money = $("#money_add").val()*10000/100;   /*金额*/
        var remark = $("#remark_add").val();
      	//var time = $("#time_add").val();
      	if(isNull(cateCode)){
            swal({
                title: "提示",
                text: "请选择类型",
                type: "warning"
            },function(){
                $("#cateCode_add").focus();
            });
            return;
		}
		$.ajax({
			url:'/${appName}/manager/bookController/addBook',
			type:'post',
			async:'true',
			cache:false,
			data:{cateCode:cateCode,money:parseInt(money.toFixed(2)),remark:remark},
			dataType:'json',
			success: function(data){
					  if(data){
                          swal({
                              title: "系统提示",
                              text: "添加成功",
                              type: "success"
                          },function(){
                              getCount(); /*获取本月消费金额*/
                              $('#table').bootstrapTable("refresh");
                              $("#cateCode_add").val('');
                              $("#money_add").val('');
                              $("#remark_add").val('');
                              $("#addwin").modal('hide');
                          });
		              }else{
		                  swal({
             					 title: "系统提示",
					             text: "添加失败",
					             type: "warning"
					         },function(){
								  $("#cateCode_add").val('');
								  $("#money_add").val('');
								  $("#remark_add").val('');
					         	  $("#addwin").modal('hide');
                              		$('#table').bootstrapTable("refresh");
					         });
		              }
		    },
            error: function (aa, ee, rr) {
	                  swal({
            				 title: "系统提示",
				             text: "请求服务器失败,清稍候再试",
				             type: "warning"
				         	},function(){
								  $("#cateCode_add").val('');
								  $("#money_add").val('');
								  $("#remark_add").val('');
					         	  $("#addwin").modal('hide');
                          			$('#table').bootstrapTable("refresh");
					         });
            }
		});
	  }
	  /*修改*/
	  function upBook(){
	        var id = $("#id_up").val();
            var cateCode = cate_code_up;
            var money = $("#money_up").val()*10000/100;   /*金额*/
            var remark = $("#remark_up").val();
            var time = $("#time_up").val();
            if(isNull(cateCode)){
                swal({
                    title: "提示",
                    text: "请选择类型",
                    type: "warning"
                },function(){
                    $("#cateCode_up").focus();
                });
                return;
            }
            $.ajax({
                url:'/${appName}/manager/bookController/upBook',
                type:'post',
                async:'true',
                cache:false,
                data:{id:id,cateCode:cateCode,money:parseInt(money.toFixed(2)),remark:remark,time:time+edit_hhmmss},
                dataType:'json',
                success: function(data){
                    if(data){
                        swal({
                            title: "系统提示",
                            text: "修改成功",
                            type: "success"
                        },function(){
                            getCount(); /*获取本月消费金额*/
							search();
                            cate_code_up = '';
                            $("#id_up").val('');
                            $("#cateCode_up").val('');
                            $("#money_up").val('');
                            $("#remark_up").val('');
                            $("#upwin").modal('hide');
                        });
                    }else{
                        swal({
                            title: "系统提示",
                            text: "修改失败",
                            type: "warning"
                        },function(){
                            search();
                            cate_code_up = '';
                            $("#id_up").val('');
                            $("#cateCode_up").val('');
                            $("#money_up").val('');
                            $("#remark_up").val('');
                            $("#upwin").modal('hide');
                        });
                    }
                },
                error: function (aa, ee, rr) {
                    swal({
                        title: "系统提示",
                        text: "请求服务器失败,清稍候再试",
                        type: "warning"
                    },function(){
                        search();
                        cate_code_up = '';
                        $("#id_up").val('');
                        $("#cateCode_up").val('');
                        $("#money_up").val('');
                        $("#remark_up").val('');
                        $("#upwin").modal('hide');
                    });
                }
            });
        }
	  /**----删除----*/
	  function delBook(id){
	  	swal({
            title: "您确定要删除这条信息吗",
            text: "删除后将无法恢复，请谨慎操作！",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "删除",
            cancelButtonText: "取消",
            closeOnConfirm: false,
            closeOnCancel: false
        	}, function (isConfirm) {
            if (isConfirm) {
                $.ajax({
					url:'/${appName}/manager/bookController/delBook',
					type:'post',
					async:'true',
					cache:false,
					data:{id:id},
					dataType:'json',
					success: function(data){
							  if(data){
                                    getCount(); /*获取本月消费金额*/
							        swal("删除成功！", "您已经删除了这条信息。", "success");
							        search();
				              }else{
				                  swal({
		             					 title: "系统提示",
							             text: "删除失败",
							             type: "warning"
							         });
				              }
				    },
		            error: function (aa, ee, rr) {
			                  swal({
		            				 title: "系统提示",
						             text: "请求服务器失败,清稍候再试",
						             type: "warning"
						         	});
		            }
				});
            } else {
                swal("已取消", "您取消了删除操作！", "error")
            }
        });
		}

		/*打开修改弹框*/
		function editBook(id,time){
		    edit_hhmmss = time.substr(10,19);  //获取时分秒
            $("#upwin").modal('show');
            $("#id_up").val(id);
            $.ajax({
                url:'/${appName}/manager/bookController/getBookById/'+id,
                type:'get',
                async:'true',
                cache:false,
                data:{},
                dataType:'json',
                success: function(data){
                    if(data){
                        $("#cateCode_up").val(data.cate_name);
                        $("#money_up").val(data.money/100);
                        $("#remark_up").val(data.remark);
                        $('#time_up').datepicker('setDate',data.time.substr(0,10));
                    }else{
                        swal({
                            title: "系统提示",
                            text: "获取数据失败",
                            type: "warning"
                        });
                    }
                },
                error: function (aa, ee, rr) {
                    swal({
                        title: "系统提示",
                        text: "请求服务器失败,清稍候再试",
                        type: "warning"
                    });
                }
            });
		}

		//查询
		function search(){
            var money_search_start=$("#money_search_start").val()*10000/100;
            var money_search_end=$("#money_search_end").val()*10000/100;
            var time_search_start=$("#time_search_start").val();
            var time_search_end=$("#time_search_end").val();
            var remark_search=$("#remark_search").val();
            $('#table').bootstrapTable('refresh', {
		      		 query: {
                         cateCode_search:cateCode_search,
                         money_search_start:parseInt(money_search_start.toFixed(2)),
                         money_search_end:parseInt(money_search_end.toFixed(2)),
                         time_search_start:time_search_start,
                         time_search_end:time_search_end,
                         remark_search:remark_search
		             }
		        });
		}

		//重置查询条件
		  function reset(){
              $("#cateCode_search").val('');
              cateCode_search='';
              $("#money_search_start").val('');
              $("#money_search_end").val('');
              $("#time_search_start").val('');
              $("#time_search_end").val('');
              $("#remark_search").val('');
		  }

		  $(function(){
		  	$('.search_ul').css({left:'0px',width:'100%'});
		  });
	</script>
	</body>
</html>