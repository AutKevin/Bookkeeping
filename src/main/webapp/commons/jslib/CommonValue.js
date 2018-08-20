

 	var split_flg="|";
 	var File_Separator="/";
 	var split_flg2=",";

    function getNowFormatDate() {
        var date = new Date();
        var seperator1 = "-";
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = year + seperator1 + month + seperator1 + strDate;
        return currentdate;
    }
    function getNowFormatMonth() {
        var date = new Date();
        var seperator1 = "-";
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }

        var currentdate = year + seperator1 + month;
        return currentdate;
    }

    function getNowFormatYear() {
        var date = new Date();
        var year = date.getFullYear();

        var currentdate = year;
        return currentdate;
    }

 	function reloadMenu(obj) {
		        var t = $('.J_iframe[data-id="' + $(obj).attr("href") + '"]'),
		        e = t.attr("src"),
		        a = layer.load();
		        t.attr("src", e).load(function() {
		            layer.close(a)
		        })
	}
 	
 	function GetQueryString(name)
	{
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  unescape(r[2]); return null;
	}
	
	
function loadUnitType(url,idStr)
{
	$.ajax({
       				url:url,	
       				dataType:'json',
       				data:{
       				},
       				type:'post',
       				success:function(data){
       					var options="<option value=''>请选择</option>";
						$.each(data.unitTypeList, function (key, val) {
				            options += '<option value=' + val.id + '>' + val.name + '</option>';
				         });
						 $('#'+idStr).empty(); 
				         $('#'+idStr).append(options);
       				},
       				error:function(){
       					
       				}
       	});
}


function loadUnitGrade(url,idStr)
{
	$.ajax({
       				url:url,	
       				dataType:'json',
       				data:{
       				},
       				type:'post',
       				success:function(data){
						var options="<option value=''>请选择</option>";
						$.each(data.unitGradeList, function (key, val) {
				            options += '<option value=' + val.id + '>' + val.name + '</option>';
				         });
						 $('#'+idStr).empty(); 
				         $('#'+idStr).append(options);
       					
       				},
       				error:function(){
       					
       				}
       	});
}
//机构下拉框
function loadUnit(url,idStr)
{
	$.ajax({
       				url:url,	
       				dataType:'json',
       				data:{
       				},
       				type:'post',
       				success:function(data){
						var options="<option value=''>请选择</option>";
						$.each(data.unitGradeList, function (key, val) {
				            options += '<option value=' + val.id + '>' + val.name + '</option>';
				         });
						 $('#'+idStr).empty(); 
				         $('#'+idStr).append(options);
       					
       				},
       				error:function(){
       					
       				}
       	});
}
//省市区下拉框
function loadCity(url,idStr,pid)
{
	$.ajax({
       				url:url,	
       				dataType:'json',
       				async:false,
       				data:{
       					parentId:pid
       				},
       				type:'post',
       				success:function(data){
						var options="<option value=''>请选择</option>";
						if(data.count>0){
						$.each(data.CityList, function (key, val) {
				            options += '<option value=' + val.areaNumber + '>' + val.name + '</option>';
				         });
				         }
						 $('#'+idStr).empty(); 
				         $('#'+idStr).append(options);
       					
       				},
       				error:function(){
       					
       				}
       	});
}
/*角色多选框*/
function loadRoleChk(url,tag_id){
	$.ajax({
 				url:url,	
 				dataType:'json',
 				data:{},
 				type:'post',
 				success:function(data){
				var options="";   //字符串拼接
				for(var i in data){  //遍历json数组
                    options += "<input type='checkbox' class='roles' name='roles' id='"+data[i].rolecode+"' value='"+data[i].rolecode+"'>"+data[i].rolename+"&nbsp;&nbsp;"
                }
				$('#'+tag_id).empty();
				$('#'+tag_id).html(options);
 				},
 				error:function(){}
       	});
}
//去掉数组中的某个值
function removeByValue(arr, val) {
  for(var i=0; i<arr.length; i++) {
    if(arr[i] == val) {
      arr.splice(i, 1);
      break;
    }
  }
}


function setIFrameContent(iframeId,value) {  
        var doc = document.getElementById(iframeId).contentDocument || document.frames[iframeId].document;  
        doc.body.innerHTML = value;  
  
}

//判断是否为空
function isEmpty(obj){
	if(typeof obj == "undefined"|| obj == "undefined"  || obj == null || obj == ""){
		return true;
	}else{
		return false;
	}
}
