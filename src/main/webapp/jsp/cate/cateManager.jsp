<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>消费类型管理</title>

		<meta name="keywords" content="消费类型">
		<meta name="description" content="消费类型">
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
							<%--<div class="row">
								<div class="col-sm-5">
									<label class="col-sm-3 control-label">
										消费类型：
									</label>
									<div class="col-sm-4 controls">
										<input type="text" value="" class="form-control" name="money" id="cate_name" tabindex="4" />
									</div>
								</div>
								<div class="col-sm-5">
									<label class="col-sm-3 control-label">
										消费等级：
									</label>
									<div class="col-sm-4 controls">
										<input type="text" value="" class="form-control" name="money" id="cate_level" tabindex="4" />
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
							</div>--%>
							<div class="row">
								<div class="col-sm-1 col-md-offset-1">
									<button class="btn btn-gmtx-define1" data-toggle="modal" href="#addwin" data-keyboard="true" data-backdrop="false" id="btn_add">
										新增
									</button>
								</div>
							</div>
						</div>
						<div class="ibox-content">
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
							消费类型添加
						</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<form method="post" class="form-horizontal" id="addform">
								<div class="form-group">
									<label class="col-sm-3 control-label">
										类型编码：
									</label>
									<div class="col-sm-8 controls">
										<input type="text" value="" class="form-control" name="code" id="cate_code_add" tabindex="11" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">
										类型名称：
									</label>
									<div class="col-sm-8 controls">
										<input type="text" value="" class="form-control" name="code" id="cate_name_add" tabindex="12" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">
										类型等级：
									</label>
									<div class="col-sm-8 controls">
										<input type="text" value="" class="form-control" name="code" id="cate_level_add" tabindex="13" />
									</div>
								</div>
								<div class="form-group">
									<div class="controls">
										<button type="submit" class="btn btn-gmtx-define1 center-block" tabindex="14">
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
		<script type="text/javascript">
		//判断为空
		function isNull(variable1){
			if (variable1 == null || variable1 == undefined || variable1 == '') { 
				return true;
			}
		}
	/**share---*/
	/*验证表单提交表单*/
	function vform(dom,func){
		$("#"+dom).validate({
				rules : {
                    cate_code : {
						required : true,
						maxlength: 50
					},
                    cate_name:{
						required : true,
						maxlength: 50,
					},
                    cate_level:{
					}
				},
				messages : {
                    cate_code : {
						required : "请输入类型编码",
						maxlength: "参数名过长"
					},
                    cate_name:{
						required: "请输入类型名称",
						maxlength: "参数名过长"
					},
                    remark:{
					}
				},
				submitHandler : function() {
					func();
				}
		});
	}


	/*---share end**/
	$(function(){
        vform('addform',addCate);

		var $table = $('#table');
	    $table.bootstrapTable({
	    url: "/${appName}/manager/cateController/getAllCate",
	    method: 'post',
		contentType: "application/x-www-form-urlencoded",
	    dataType: "json",
	    pagination: true, //分页
        sidePagination: "server", //服务端处理分页
        pageList: [5, 10, 25],
	    pageSize: 5,
	    pageNumber:1,
	    //toolbar:"#tb",
	    singleSelect: false,
	    queryParamsType : "limit",
	    queryParams: function queryParams(params) {   //设置查询参数
          var param = {
            pageNo: params.offset/params.limit+1,  //offset为数据开始索引,转换为显示当前页
            pageSize: params.limit  //页面大小
          };
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
                    title: '类型编码',
                    field: 'cate_code',
                    valign: 'middle'
                },
                {
                    title: '消费等级',
                    field: 'cate_level',
                    valign: 'middle'
                },
                {
                    title: '操作',
                    field: '',
                    formatter:function(value,row,index){
                        var d = '<a href="#" class="btn btn-gmtx-define1" onclick="delCate(\''+ row.cate_code +'\')">删除</a> ';
                        return d;
                  	 }
                }
            ]
	      });
      });
      /**------添加------*/
      function addCate(){
        var cate_code = $("#cate_code_add").val();
      	var cate_name = $("#cate_name_add").val();
      	var cate_level = $("#cate_level_add").val();
		$.ajax({
			url:'/${appName}/manager/cateController/addCate',
			type:'post',
			async:'true',
			cache:false,
			data:{cate_code:cate_code,cate_name:cate_name,cate_level:cate_level},
			dataType:'json',
			success: function(data){
					  if(data.success=='true'){
                          swal({
                              title: "系统提示",
                              text: "添加成功",
                              type: "success"
                          },function(){
                              $('#table').bootstrapTable("refresh");
                              $("#cate_code_add").val('');
                              $("#cate_name_add").val('');
                              $("#cate_level_add").val('');
                              $("#addwin").modal('hide');
                          });
		              }else if(data.success=='false'){
		                  swal({
             					 title: "系统提示",
					             text: "添加失败",
					             type: "warning"
					         },function(){
								  $("#cate_code_add").val('');
								  $("#cate_name_add").val('');
								  $("#cate_level_add").val('');
					         	  $("#addwin").modal('hide');
							      $('#table').bootstrapTable("refresh");
					         });
		              }else if(data.success=='false2'){
                          swal({
                              title: "系统提示",
                              text: "添加失败，"+data.msg,
                              type: "warning"
                          },function(){
                              $("#cate_code_add").val('');
                              $("#cate_name_add").val('');
                              $("#cate_level_add").val('');
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
								  $("#cate_code_add").val('');
								  $("#cate_name_add").val('');
								  $("#cate_level_add").val('');
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
                url:'/${appName}/manager/cateController/upBook',
                type:'post',
                async:'true',
                cache:false,
                data:{id:id,cateCode:cateCode,money:money,remark:remark,time:time},
                dataType:'json',
                success: function(data){
                    if(data){
                        swal({
                            title: "系统提示",
                            text: "修改成功",
                            type: "success"
                        },function(){
                            $('#table').bootstrapTable("refresh");
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
                            text: "添加失败",
                            type: "warning"
                        },function(){
                            $('#table').bootstrapTable("refresh");
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
                        $('#table').bootstrapTable("refresh");
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
	  function delCate(id){
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
					url:'/${appName}/manager/cateController/delCate',
					type:'post',
					async:'true',
					cache:false,
					data:{cate_code:id},
					dataType:'json',
					success: function(data){
                        console.info(data);
							  if(data.success == 'true'){
							        swal("删除成功！", "您已经删除了这条信息。", "success");
					         		$('#table').bootstrapTable("refresh");
				              }else if(data.success == 'false1'){
				                  swal({
		             					 title: "系统提示",
							             text: "删除失败",
							             type: "warning"
							         });
				              }else if(data.success == 'false2'){
                                  swal({
                                      title: "系统提示",
                                      text: data.msg,
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

	</script>
	</body>
</html>