<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleAccountBalanceProxyid" scope="session" class="accountSolde.AccountBalanceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleAccountBalanceProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleAccountBalanceProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleAccountBalanceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        accountSolde.AccountBalance getAccountBalance10mtemp = sampleAccountBalanceProxyid.getAccountBalance();
if(getAccountBalance10mtemp == null){
%>
<%=getAccountBalance10mtemp %>
<%
}else{
        if(getAccountBalance10mtemp!= null){
        String tempreturnp11 = getAccountBalance10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String id_1id=  request.getParameter("id16");
        int id_1idTemp  = Integer.parseInt(id_1id);
        String val_2id=  request.getParameter("val18");
        double val_2idTemp  = Double.parseDouble(val_2id);
        sampleAccountBalanceProxyid.transfert(id_1idTemp,val_2idTemp);
break;
case 20:
        gotMethod = true;
        String id_3id=  request.getParameter("id23");
        int id_3idTemp  = Integer.parseInt(id_3id);
        double getMoney20mtemp = sampleAccountBalanceProxyid.getMoney(id_3idTemp);
        String tempResultreturnp21 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getMoney20mtemp));
        %>
        <%= tempResultreturnp21 %>
        <%
break;
case 25:
        gotMethod = true;
        String id_4id=  request.getParameter("id28");
        int id_4idTemp  = Integer.parseInt(id_4id);
        String val_5id=  request.getParameter("val30");
        double val_5idTemp  = Double.parseDouble(val_5id);
        boolean pay25mtemp = sampleAccountBalanceProxyid.pay(id_4idTemp,val_5idTemp);
        String tempResultreturnp26 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(pay25mtemp));
        %>
        <%= tempResultreturnp26 %>
        <%
break;
case 32:
        gotMethod = true;
        String id_6id=  request.getParameter("id35");
        int id_6idTemp  = Integer.parseInt(id_6id);
        sampleAccountBalanceProxyid.addClient(id_6idTemp);
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>