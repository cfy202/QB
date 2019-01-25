[#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] /]
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="[@spring.url '/resources/images/favicon.png'/]">

    <title>${message("admin.main.title")}</title>
[#include "/admin/include/head.ftl"]
</head>
<body>

<!-- Fixed navbar -->
[#include "/admin/include/navbar.ftl"]
<div id="cl-wrapper" class="fixed-menu">
[#include "/admin/include/sidebar.ftl"]
    <div class="container-fluid" id="pcont">
        <div class="page-head">
            <h3>Statistics</h3>
            <div class="new">
	        	<a class="btn pull-right" href="javascript:history.go(-1)"><i class="fa fa-reply" title="Back"></i></a>
	        </div>
            <ol class="breadcrumb">
                <li><a href="#">Home</a></li>
                <li><a href="#">Statistics</a></li>
            </ol>
        </div>
        <div class="cl-mcont">
		<div class="row">
			<div class="col-md-12">
					<div class="block-flat">
						<div class="tab-container">
							<div class="tab-content">
								<input type="hidden" value="${so.time}${so.year}" id="time"/>
								<input type="hidden" value="${role}" id="role"/>
								<input type="hidden" value="${so.agentId}" id="agentId"/>
								<!--<label>
					            	<select  class="select2" id="year" onChange="bookingPeerYear()">
										[#list constant.BRAND_YEAR as val]
											<option value="${val}"[#if "${year==val}"]selected="selected"[/#if]>${val}</option>
										[/#list]
									</select>
								</label>
								<label>
					            	<select  class="select2" id="deptId" onChange="sear()">
										<option value="">Select Office</option>
										[#list dept as dept]
											<option value="${dept.deptId}" [#if "${dept.deptId=so.deptId}"]selected="selected"[/#if]>${dept.deptName}</option>
										[/#list]
									</select>
								</label>
								-->
								<!--	<label>
									<input name="companyId" type="hidden" id="userSelect" style="width:100%" doName="4808" required="" onChange="sear()"/>
										<input name="company" type="hidden">
								</label>
								-->
								
								<label>Booking Date:
									<input type="text" id="booking_beginningDate" size="14"  placeholder="Beginning Date." value="${so.beginningDate?string("yyyy-MM-dd")}" />
								</label>
								<label>to:
									<input type="text" id="booking_endingDate" size="14"  placeholder="Ending Date." value="${so.endingDate?string("yyyy-MM-dd")}" />
								</label>
								<input id="tlsum" value="${statisticalList?size}" type="hidden"/>
								&nbsp;&nbsp;
								<input class="submit-btn"  type="submit" value="Search" onClick="sear()">
                                <table class="table table-bordered" id="datatable2">
                                    <thead>
                                     <tr>
                                 	   <th>Office</th>
	                                    <th>Qty</th>
	                                    <th>Total Profit</th>
	                                    <th>Airline</th>
	                                    <th>BI</th>
	                                    <th>BD</th>
	                                    <th>EI</th>
	                                    <th>ED</th>
	                                    <th>Net</th>
	                                    <th>Total</th>
	                                    <th>Profit</th>
	                                </tr>
                                	 [#list statisticalList as st]
	                                    <tr [#if st_index%2==1] style="background-color:#fff"[/#if][#if st_index%2==0] style="background-color:#EFF8FE"[/#if]>
	                                        <td rowspan="${st.flightList.size()+1}" style="text-align:center;vertical-align:middle">${st.deptName}</td>
	                                        <td rowspan="${st.flightList.size()+1}" style="text-align:center;vertical-align:middle" id="sumb${st_index}">${st.sum}</td>
	                                        <td rowspan="${st.flightList.size()+1}" style="text-align:center;vertical-align:middle" id="sumb${st_index}">${st.profit}</td>
	                                        <input id="zlsum${st_index}" value="${st.flightList?size}" type="hidden"/>
	                                    </tr>
	                                   [#list st.flightList as flight]
	                                   	<tr>
	                                        <!-- <td><a href="javascript:;" onclick="viewInfor('${flight.airline}','${flight.deptId}')">${flight.airline}</a></td> -->
	                                        <td>${flight.airline}</td>
	                                        <td>${flight.BI}</td>
	                                        <td>${flight.BD}</td>
	                                        <td>${flight.EI}</td>
	                                        <td>${flight.ED}</td>
	                                        <td>${flight.net}</td>
	                                        <td>${flight.operatorFee}</td>
	                                        <td>${flight.amount-flight.operatorFee}</td>
	                                    </tr>
	                                   [/#list]
	                                [/#list]
                                    </thead>
                                </table>
						</div>
		</div>
    </div>
</div>
[#include "/admin/include/foot.ftl"]
<script type="text/javascript">
    $(document).ready(function () {
        //initialize the javascript
        App.init();
        [@flash_message /]
		$("#booking_beginningDate").datepicker({dateFormat: 'yy-mm-dd',changeYear: true,changeMonth: true });
		$("#booking_endingDate").datepicker({dateFormat: 'yy-mm-dd',changeYear: true,changeMonth: true });
    });
    function sear() {
			var role=$("#role").val();
			var beginningDate=$("#booking_beginningDate").val();
        	var endingDate=$("#booking_endingDate").val();
        	
        	location.href="${base}/admin/statistical/airlineStatisticalBooking.jhtml?beginningDate="+beginningDate+"&endingDate="+endingDate;
		}
		
		//查看详情
		function viewInfor(a){
			var role=$("#role").val();
        	var arrivalBeginningDate=$("#arrival_beginningDate").val();
        	var arrivalEndingDate=$("#arrival_endingDate").val();
        	var airline=a;
    		location.href="${base}/admin/statistical/ticketList.jhtml?airline="+airline+"&beginningDate="+beginningDate+"&endingDate="+endingDate;
		}
		//获取两位小数点
	function changeTwoDecimal(x){
			var f_x = parseFloat(x);
			if (isNaN(f_x))
			{
				//alert('function:changeTwoDecimal->parameter error');
				return false;
			}
			var f_x = Math.round(x*100)/100;
		
			return f_x;
		}
</script>
</body>
</html>
