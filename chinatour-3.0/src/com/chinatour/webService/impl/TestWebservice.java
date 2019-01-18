/**
 * 
 */
package com.chinatour.webService.impl;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;

import com.chinatour.entity.Customer;
import com.chinatour.entity.CustomerFlight;
import com.chinatour.entity.Order;
import com.chinatour.entity.OrderReceiveItem;
import com.chinatour.entity.ReceivableInfoOfOrder;
import com.chinatour.entity.TourInfoForOrder;
import com.chinatour.vo.SingleOrdersVO;
import com.chinatour.webService.GroupLineInterface;
import com.google.gson.Gson;


/**
 * @copyright   Copyright: 2014 
 * @author Aries
 * @create-time 2015-1-16 下午2:10:02
 * @revision  3.0
 */

public class TestWebservice {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		Gson gson = new Gson();
		org.codehaus.xfire.service.Service srvcModel = new ObjectServiceFactory().create(GroupLineInterface.class);
		XFireProxyFactory factory = new XFireProxyFactory(XFireFactory.newInstance().getXFire()); 
		String helloWorldURL = "http://localhost:8080/chinatour-3.0/service/serviceInterface";
		GroupLineInterface impl=null;
		try {
			impl= (GroupLineInterface) factory.create(srvcModel, helloWorldURL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		/*OrderFinanceInvoice of=new OrderFinanceInvoice();*/
		/*of.setTimeStart("2015-01-01");*/
		/*of.setOrderNo("124255");*/
		/*String ll = gson.toJson(of);*/
		/*String a = impl.getGroupLineByCode("6PCY14","InterTrips");
		System.out.println(a);*/
		/*String a = impl.getLanguage();*/
		/*String a = impl.getStatisticsRevenueCost("580a3e80-24d4-11e4-a0d1-00163e002f1d", ll);*/
		/*String[] a=impl.getByOrderNo("580a3e80-24d4-11e4-a0d1-00163e002f1d", "124255");
		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
		System.out.println(a[3]);*/
		/*System.out.println(a.toString());*/
		
		Order order = new Order();
		order.setUserId("9a75b3c0-334e-11e4-b177-00163e002f1d");  //必填
		order.setTotalPeople(2);
		order.setTourCode("SGJN0901");
		order.setContactName("NXH");
		order.setTax(0);
		order.setOrderNoIn("wenjing");
		order.setRefNo("七七七七七");
		
		List<Customer> cList = new ArrayList<Customer>();
		
		Customer c = new Customer();
		c.setFirstName("TestOne");
		c.setLastName("Test");
		c.setBirthday("2015-02-12") ;    //必填  没有值也要以空字符””传值
		c.setNationalityOfPassport("CHINA");
		c.setPassportNo("GX1111");
		c.setPassportDate("");   //必填  没有值也要以空字符””传值
		c.setSex(2);        //2.男    1.女
		c.setTel("13709595556");
		c.setLanguageId("e4a1251b-8229-11e2-8c18-94de800a7ba1");
		c.setMemoOfCustomer("New Clients");
		c.setGuestRoomType("Twin Bed");  //房型  必填
		c.setRoomNumber(1);
		c.setRoomIsFull(2);
		
		List<CustomerFlight> cfList1=new ArrayList<CustomerFlight>();
		CustomerFlight cf1 =new CustomerFlight();
		cf1.setFlightNumber("1200");
		cf1.setFlightCode("CZ");
		cf1.setArriveTime("12:00");
		cf1.setArriveDateStr("2015-02-03");     //必填  没有值也要以空字符””传值
		cf1.setOutOrEnter(1);//		入境出境必填---2：出境 ， 1：入境
		cf1.setIfPickUp(1);
		cfList1.add(cf1);
		CustomerFlight cf2 =new CustomerFlight();
		cf2.setFlightNumber("8955");
		cf2.setFlightCode("MM");
		cf2.setArriveTime("15:00");
		cf2.setArriveDateStr("2015-02-01");     //必填  没有值也要以空字符””传值
		cf2.setOutOrEnter(2);//		入境出境必填---2：出境 ， 1：入境
		cf2.setIfSendUp(1);
		cfList1.add(cf2);
		c.setCustomerFlightList(cfList1);
		cList.add(c);

		Customer c1 = new Customer();
		c1.setFirstName("TestTwo");
		c1.setLastName("Two");
		c1.setBirthday("1991-03-02") ;    //必填  没有值也要以空字符””传值
		c1.setNationalityOfPassport("CHINA");
		c1.setPassportDate("2018-11-11");   //必填  没有值也要以空字符””传值
		c1.setPassportNo("G32748597");
		c1.setSex(2);      //2.男    1.女
		c1.setTel("13709595556");
		c1.setLanguageId("b42bd96c-3cf9-11e2-9ada-fcde614b56cb");
		c1.setMemoOfCustomer("新客人");
		c1.setGuestRoomType("Twin Bed");  //房型  必填
		c1.setRoomNumber(1);
		c1.setRoomIsFull(2);
		
		List<CustomerFlight> cfList2=new ArrayList<CustomerFlight>();
		CustomerFlight cf3 =new CustomerFlight();
		cf3.setFlightCode("MU5716");
		cf3.setArriveDateStr("2015-03-11");     //必填  没有值也要以空字符””传值
		cf3.setOutOrEnter(1);//        入境出境必填---2：出境 ， 1：入境
		cfList2.add(cf3);
		CustomerFlight cf4 =new CustomerFlight();
		cf4.setFlightCode("MU5716");
		cf4.setArriveDateStr("2015-03-18");     //必填  没有值也要以空字符””传值]
		cf4.setOutOrEnter(2);//      入境出境必填---2：出境 ， 1：入境
		cfList2.add(cf4);
		c1.setCustomerFlightList(cfList2);
		cList.add(c1);
		
		Customer c3 = new Customer();
		c3.setFirstName("Child");
		c3.setLastName("DC");
		c3.setBirthday("1991-03-02") ;    //必填  没有值也要以空字符””传值
		c3.setNationalityOfPassport("CHINA");
		c3.setPassportDate("2018-11-11");   //必填  没有值也要以空字符””传值
		c3.setPassportNo("G32748597");
		c3.setSex(2);      //2.男    1.女
		c3.setTel("13709595556");
		c3.setLanguageId("b42bd96c-3cf9-11e2-9ada-fcde614b56cb");
		c3.setMemoOfCustomer("新客人");
		c3.setGuestRoomType("Suite");  //房型  必填
		c3.setRoomNumber(1);
		c3.setRoomIsFull(0);
		
		List<CustomerFlight> cfList3=new ArrayList<CustomerFlight>();
		CustomerFlight cf5 =new CustomerFlight();
		cf5.setFlightCode("MU5716");
		cf5.setArriveDateStr("2015-03-11");     //必填  没有值也要以空字符””传值
		cf5.setOutOrEnter(1);//        入境出境必填---2：出境 ， 1：入境
		cfList3.add(cf5);
		CustomerFlight cf6 =new CustomerFlight();
		cf6.setFlightCode("MU5716");
		cf6.setArriveDateStr("2015-03-18");     //必填  没有值也要以空字符””传值]
		cf6.setOutOrEnter(2);//      入境出境必填---2：出境 ， 1：入境
		cfList3.add(cf6);
		c3.setCustomerFlightList(cfList3);
		cList.add(c3);
		
		TourInfoForOrder t = new TourInfoForOrder();
		t.setScheduleLineCode("SGJN0901");
		t.setGroupLineId("03857a0a-5021-11e4-9711-00163e002f1d");
		t.setLineName("青青草原");
		t.setArriveTime("2015-02-20");    //必填
		t.setSpecialRequirements("PLEASE Cancel this, API test only!!");
		t.setTourInfo("TESTING ONLY, Please DELETE this booking!");
		//费用
		List<OrderReceiveItem> itemList=new ArrayList<OrderReceiveItem>(); 
		OrderReceiveItem item1=new OrderReceiveItem();
		item1.setType(1);
		item1.setItemFee(new BigDecimal(100));
		item1.setItemFeeNum(1);
		item1.setNum(101);
		OrderReceiveItem item2=new OrderReceiveItem();
		item2.setType(2);
		item2.setItemFee(new BigDecimal(100));
		item2.setRemark("11111");
		item2.setNum(201);
		itemList.add(item1);
		itemList.add(item2);
		ReceivableInfoOfOrder re=new ReceivableInfoOfOrder();
		re.setSumFee(new BigDecimal(100));
		re.setTotalCommonTourFee(new BigDecimal(100));
		re.setTotalFeeOfOthers(new BigDecimal(100));
		re.setOrderReceiveItemList(itemList);
		
		//visa
		SingleOrdersVO sv=new SingleOrdersVO();
		List<OrderReceiveItem> visaFeeList=new ArrayList<OrderReceiveItem>();
		OrderReceiveItem item3=new OrderReceiveItem();
		item1.setType(1);
		item1.setItemFee(new BigDecimal(100));
		item1.setItemFeeNum(1);
		item1.setNum(100);
		OrderReceiveItem item4=new OrderReceiveItem();
		item2.setType(1);
		item2.setItemFee(new BigDecimal(100));
		item2.setRemark("11111");
		item2.setNum(101);
		visaFeeList.add(item1);
		visaFeeList.add(item2);
		sv.setVisaFeeList(visaFeeList);
		
		ReceivableInfoOfOrder re1=new ReceivableInfoOfOrder();
		re1.setSumFee(new BigDecimal(100));
		re1.setTotalCommonTourFee(new BigDecimal(100));
		re1.setTotalFeeOfOthers(new BigDecimal(100));
		sv.setReceivableInfoOfOrder(re1);
		order.setSingleOrdersVO(sv);
		
		String orders = gson.toJson(order);
		String customerList = gson.toJson(cList);
		String tourInfoForOrder = gson.toJson(t);
		String receivableInfoOfOrder=gson.toJson(re);
		
		GroupLineInterface oit=null;
		try {
			oit = (GroupLineInterface) factory.create(srvcModel,helloWorldURL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		String q=oit.saveOrderWeb(orders, customerList, tourInfoForOrder,receivableInfoOfOrder);
		System.out.println(q);
		
		/*ProductFee product=new ProductFee();
		
		ReceivableInfoOfOrder rec=new ReceivableInfoOfOrder();*/
		/*rec.setTotalCommonTourFee(new BigDecimal(152));*/
		/*rec.setTotalFeeOfOthers(new BigDecimal(589));*/
		/*rec.setSumFee(new BigDecimal(8963));*///必填,总金额

	/*product.setReceivableInfoOfOrder(rec);*/
		//费用明细
	/*	OrderReceiveItem itme1=new OrderReceiveItem();
		itme1.setItemFee(new BigDecimal(100));
		itme1.setItemFeeNum(1);
		itme1.setType(1);//常规团费类型       1.常规团费类型   2.其他费用   3.其他折扣
		itme1.setNum(101);//成人费用标示（固定）
		product.setAdultItem(itme1);
		
		OrderReceiveItem itme2=new OrderReceiveItem();
		itme2.setItemFee(new BigDecimal(52));
		itme2.setItemFeeNum(1);
		itme2.setType(1);//常规团费类型       1.常规团费类型   2.其他费用   3.其他折扣
		itme2.setNum(102);//小孩费用标示（固定）
		product.setChildrenItem(itme2);
		
		List<OrderReceiveItem> ol=new ArrayList<OrderReceiveItem>();
		
		OrderReceiveItem itme3=new OrderReceiveItem();
		itme3.setItemFee(new BigDecimal(53));
		itme3.setRemark("dgfdg");
		itme3.setType(2);//常规团费类型       1.常规团费类型   2.其他费用   3.其他折扣
		itme3.setNum(201);//其他费用标示（规则：20后面追加--1、2、3、）
		ol.add(itme3);
		
		OrderReceiveItem itme4=new OrderReceiveItem();
		itme4.setItemFee(new BigDecimal(54));
		itme4.setRemark("dgfdg");
		itme4.setType(2);//常规团费类型       1.常规团费类型   2.其他费用   3.其他折扣
		itme4.setNum(202);//其他费用标示（规则：20后面追加--1、2、3、）
		ol.add(itme4);
		

		product.setOtherFeeList(ol);

		List<OrderReceiveItem> di=new ArrayList<OrderReceiveItem>();
		OrderReceiveItem itme5=new OrderReceiveItem();
		itme5.setItemFee(new BigDecimal(88));
		itme5.setRemark("dgfdg");
		itme5.setType(3);//常规团费类型       1.常规团费类型   2.其他费用   3.其他折扣
		itme5.setNum(301);//其他折扣标示（规则：30后面追加--1、2、3、）
		di.add(itme5); 

		product.setDiscountList(di);*/
		
/*
		String productVO=gson.toJson(product);
		
		GroupLineInterface oit=null;
		try {
			oit = (GroupLineInterface) factory.create(srvcModel,helloWorldURL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		String q=oit.updateOrder("A150224097", productVO);
		System.out.println(q);
*/
		//产品添加测试
		/*GroupLine groupline=new GroupLine();
		groupline.setTourCode("60130009991");
		groupline.setBrand("New Product");
		groupline.setTourName("神奇印度，世界文化遗产6日9991");
		groupline.setTripDesc("热门景点：【万寿台大纪念碑】  【凯旋门】  【妙香山】  【普贤寺】  【—板门店景区】  【王建王陵】  【万景台】  【祖国解放战争胜利纪念馆】");
		groupline.setDepartureDate("2016-03-08,2016-03-22,2016-04-05,2016-04-19,2016-05-10,2016-05-24,2016-06-07,2016-06-21,2016-07-05,2016-07-19,2016-08-09,2016-08-23,2016-09-06,2016-09-20,2016-10-11,2016-10-25,2016-11-08,2016-11-22,2016-12-13,2016-12-27");
		groupline.setSpecificItems("<p>1.接待标识“文景假期”。</p><p>2.国际机票价格，签证费用等请谘询您的旅行社。</p><p>3.为保证团队气氛和谐，仅限美国/加拿大/澳大利亚/欧洲等国公民或美国绿卡/加拿大枫叶卡/澳洲永久居住证明/欧洲永久居住证明持有的华人华侨参加；特价团报名之后无论任何原因均不得退团。</p><p>4.每天均有购物安排，购物纯属自愿。绝无任何强迫购物行为，但团员不得以任何理由拒绝逛店参观。旅途中购买的商品品质/价格、售后服务等请与商店联系，均与组团社无关。</p><p>5.游客必须随团旅行，不得中途脱团（如脱团每天需补回旅行社$50/人/天）。</p><p>6.儿童收费标准：2岁以下小童不占床免费,2岁以上-12岁以下小童不占床$150/人，占床$380/人。儿童自费以2岁为界，2岁以下免费，表演无座位，2岁以上全价。小费以2岁为界，2岁以下免费，2岁以上全价。不占床儿童无早餐。&nbsp;</p><p>7.单人房差$240/人, 酒店续住价格: $150/间/晚（双人房）&nbsp;</p><p>8.接机时间：新德里机场 ，12：00，18：00，24：00根据客人航班时间分三批接机。&nbsp;</p><p>9.送机时间：新德里机场，19:30出发前往送机。</p><p>10.我社有权在不影响游览节目的前提下对行程做次序调整，本公司拥有最终解释权。</p><p>11.抵达日期前15天截止收客，抵达日期前5天请向旅行社再次确认最终酒店资讯。</p><p>12.亚洲团抵达前15天内不得取消，如果取消，将收取团费+自费+小费全额作为取消损失费用。提前16天及以上取消：手续费$50/位。</p><p>13.其他未尽事宜请谘询组团社，凡报名之客人均视为瞭解/接收组团社之旅游条款。 &nbsp;</p><p><br/></p><p><br/></p><p>订位及取消办法&nbsp;</p><p>1.报名：请携带有效旅游证件至代理旅行社办理报名手续，需提供旅游证件影本，填写报名表并签字。</p><p>2.订金：报名订位须同时缴交全部团款。本公司收到订金后，有权立即开具国际机票，从代理旅行社收到团款之时起，旅游合同即告成立。 &nbsp;</p><p>3.更改：对于交付团款后则不可有任何更改。如一定需要更改，则按取消办法处理。 &nbsp;</p><p>4.取消订位及退款办法：取消订位需以书面方式通知本公司办理，恕不接受口头取消。无论任何非本公司原因而导致的取消订位均会产生罚款。此外，不论在出发日期前多久，如果国际机票已开，则因此产生的全部退票费用，包括各种手续费等也需客人按航空公司规定自行负担。&nbsp;</p><p>•45天前: USD $200每人次；</p><p>•30天及以内: USD $400每人次。</p><p><br/></p>");
		groupline.setDestination("新德里");
		groupline.setPlaceStart("新德里");
		groupline.setAttractions("琥珀堡,风之宫,古天文台,莲花寺,胜利宫,红堡,加德古塔,康诺特,总统官邸,国王大道,新德里国会大厦,圣雄甘地旧址纪念馆,印度门,阿格拉堡,泰姬陵");
		groupline.setRemark("8");
		groupline.setDestinationlist("斋浦尔,新德里,阿格拉");
		List<GroupRoute> gList=new ArrayList<GroupRoute>();
		GroupRoute g1=new GroupRoute();
		g1.setDayNum(1);
		g1.setRouteName("原居地 / 南昌");
		g1.setRouteDescribeForEn("早上乘坐豪华班机飞往中国南昌，即将开始您的奢华之旅");
		g1.setRouteDescribeForUs("早上乘坐豪华班机飞往中国南昌，即将开始您的奢华之旅");
		GroupRoute g2=new GroupRoute();
		g2.setDayNum(2);
		g2.setRouteName("原居地 / 南昌");
		g2.setRouteDescribeForEn("早上乘坐豪华班机飞往中国南昌，即将开始您的奢华之旅");
		g2.setRouteDescribeForUs("早上乘坐豪华班机飞往中国南昌，即将开始您的奢华之旅");
		g2.setHotel("南昌东方豪景花园酒店五星或同级");
		
		gList.add(g1);
		gList.add(g2);
		groupline.setGroupRoute(gList);
		
		String g=gson.toJson(groupline);
		String ss=impl.addGroupLine(g);
		System.out.println(ss);*/
	}

}
