import com.google.gson.GsonBuilder
import kyoshujotool.HTMLParser
import org.junit.Test

class HTMLParserTests {

    @Test
    fun parseTest() {
        val result = HTMLParser().parseAvailability(sampleHTML)
        val json = GsonBuilder().setPrettyPrinting().create()
            .toJson(result)

        println(json)
    }

    val sampleHTML = """
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

        <html>
        <head>
        	<META http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
        	<link rel="stylesheet" href="/common/css/main.css" type="text/css">
        	<link rel="stylesheet" href="/common/css/reserve.css" type="text/css">
        	<link rel="stylesheet" href="/30350001/css/main.css" type="text/css">
        	<script language="javascript" src="/common/js/common.js"></script>
        	<title>武蔵境自動車教習所-インターネット予約システム</title>
        	<script type="text/javascript">
        	<!--
        		window.onload = init;

        		function init() {
        			
        			focusText();
        		}
        	//-->
        	</script>
        	<script src="/el25/struts/utils.js" type="text/javascript"></script>
        </head>
        <body>
        <table border="0" width="100%" height="100%" cellpadding="0" cellspacing="0">
        	<tr>
        		<td align="center">
        			<!-- ヘッダー -->
        			<table class="base" cellspacing="1">
        				<tr>
        					<td align="left" class="banner" valign="middle">
        						<a href="http://www.musasisakai-ds.co.jp/" target="_brank"><img src="/30350001/img/logo/予約画面ヘッダー_20180320.jpg" border="0"></a>
        					</td>
        					<td align="right" class="banner" valign="bottom">
        						<a href="https://www.e-license.jp/el25/?abc=zA5IKlz%2B5to%2BbrGQYS%2B1OA%3D%3D&senisakiCd=5" target="_brank"><img src="/30350001/img/banner/white.png" border="0"></a>
        						<a href="https://www.e-license.jp/el25/?abc=zA5IKlz%2B5to%2BbrGQYS%2B1OA%3D%3D&senisakiCd=5" target="_brank"><img src="/30350001/img/banner/keitaisumaho2.png" border="0"></a>
        						<a href="https://www.e-license.jp/el25/?abc=zA5IKlz%2B5to%2BbrGQYS%2B1OA%3D%3D&senisakiCd=5" target="_brank"><img src="/30350001/img/banner/QRcode.png" border="0"></a>
        					</td>
        					<td align="right" valign="bottom">
        						
        							
        							
        						
        						<a href="/el25/pc/logout.action?b.schoolCd=zA5IKlz%2B5to%2BbrGQYS%2B1OA%3D%3D&amp;senisakiCd=4"><img src="/common/img/logout.png" alt="ログアウト" border="0"></a>
        					</td>
        				</tr>
        			</table>
        		</td>
        	</tr>
        	<tr>
        		<td align="center">
        			<table class="base">
        				<tr class="bgcolor">
        					<td>
        						<font size="4"><b>技能予約</b></font>
        					</td>
        				</tr>
        				<tr class="main">
        					<td valign="top" align="center">
        						



        <script type="text/javascript">
        <!--

        function sendContent(date, period, processCd, thisForm) {
        	document.getElementById('date').value = date;
        	document.getElementById('period').value = period;
        	sendLink(processCd, thisForm);
        }

        //-->
        </script>

        <form id="formId" name="form" action="/el25/pc/p03a.action" method="post">
        	<table class="base" border="0" cellpadding="0" cellspacing="0">
        		<tr class="main">

        			<!-- １列目　メニュー -->
        			




        <td valign="top">
        	<table style="width:125px; margin-top:0px;">
        		<tr>
        			<td class="bglightblue">■メニュー</td>
        		</tr>
        	</table>
        	<table class="menu">
        		
        			
        				<tr class="main" valign="middle">
        					<td style="width:5px;">&nbsp;</td>
        					<td class="right-button">
        						<a href="#" onclick="sendLink('PN',document.getElementById('formId'))">ポイント</a>
        					</td>
        				</tr>
        			
        		
        		
        		
        		
        		

        		
        			<tr>
        				<td colspan="2"><hr></td>
        			</tr>
        			<tr></tr>
        		
        		
        			<tr class="main" valign="middle">
        				<td style="width:5px;">&nbsp;</td>
        				<td class="right-button">
        		 			<a href="#" onclick="sendLinkGinou('A','0',document.getElementById('formId'))">技能予約</a>
        		 		</td>
        			</tr>
        		
        		
        		
        		
        			<tr valign="middle">
        				<td style="width:5px;">&nbsp;</td>
        		 		<td class="right-button">
        		 			<a href="#" onclick="sendLink('D',document.getElementById('formId'))">検定予約</a>
        		 		</td>
        			</tr>
        		
        		
        			<tr valign="middle">
        				<td style="width:5px;">&nbsp;</td>
        		 		<td class="right-button">
        		 			<a href="#" onclick="sendLinkGinou('A','1',document.getElementById('formId'))">応急予約</a>
        		 		</td>
        			</tr>
        		
        		
        		
        			<tr valign="middle">
        				<td style="width:5px;">&nbsp;</td>
        		 		<td class="right-button">
        	 				<a href="#" onclick="sendLink('F',document.getElementById('formId'))">キャンセル</a>
        		 		</td>
        			</tr>
        		
        		
        				
        		
        			<tr>
        				<td colspan="2"><hr></td>
        			</tr>
        		
        		<tr></tr>
        		
        		
        		 
        		 
        		
        		
        		
        		

        		
        		


        		
        		
        		
        			<tr valign="middle">
        				<td style="width:5px;">&nbsp;</td>
        		 		<td class="right-button">
        		 			<a href="#" onclick="sendLink('J',document.getElementById('formId'))">登録内容変更</a>
        		 		</td>
        			</tr>
        		
        		
        			<tr valign="middle">
        				<td style="width:5px;">&nbsp;</td>
        		 		<td class="right-button">
        		 			<a href="#" onclick="sendLink('K',document.getElementById('formId'))">メール変更</a>
        		 		</td>
        			</tr>
        		

        	</table>
        </td>


        			<!-- ２列目　中央部 -->
        			
        			
        				


        <style>
        span.carChange,
        span.instructorChange {
        	position: absolute;
        	left: 0;
        	color: #FFFFFF;
        	top: 5px;
        	font-weight: normal;
        	text-align: center;
        	width: 9em;
        }

        /*13時限時に車種名が改行されるので、横幅を上書き*/
        table .set, table .set2 {
        	width: 635px;
        }

        </style>
        <td class="center" valign="top">
        	<table class="set" cellspacing="0">
        		<tr>
        			
        				<td class="carChange" style="padding-left:15px;">
        					車種：&nbsp;&nbsp;ＡＴ限１
        				</td>
        				<td class="carChange" width="106" style="padding-right:20px;position: relative;">
        					<a href="#" onclick="sendLink('O',document.getElementById('formId'))">
        						
        						
        							<img src="/common/img/car-noname.png" alt="車種変更" border="0"><span class="carChange">車種変更</span>
        						
        					</a>
        				</td>
        			
        			
        				<td  class="instructorChange" style="padding-left:20px;">
        					指名：&nbsp;&nbsp;なし
        				</td>
        				<td class="instructorChange" width="106" style="padding-right:20px;position:relative;">
        					<a href="#" onclick="sendLink('P',document.getElementById('formId'))">
        					
        					
        						<img src="/common/img/choise-noname.png" alt="指名変更" border="0"><span class="instructorChange">指名変更</span>
        					
        					</a>
        				</td>
        			
        		</tr>
        	</table>
        	<hr>
        	<table class="set2" cellspacing="0">
        		<tr>
        			<td align="left" bgcolor="#FFFFFF" width="17%">
        				
        			</td>
        			<td align="center" bgcolor="#FFFFFF" width="66%">
        				<font size="3" color="#000099"><b>4月15日〜4月21日の技能予約
        				
        				</b></font>
        			</td>
        			<td align="left" bgcolor="#FFFFFF" width="17%">&nbsp;</td>
        		</tr>
        	</table>
        	<table class="set" cellspacing="1">
        		<tr class="carender">
        			<td width="45"></td>
        			
        				<td align="center">
        					1<BR>08:10
        				</td>
        			
        				<td align="center">
        					2<BR>09:10
        				</td>
        			
        				<td align="center">
        					3<BR>10:10
        				</td>
        			
        				<td align="center">
        					4<BR>11:10
        				</td>
        			
        				<td align="center">
        					5<BR>12:10
        				</td>
        			
        				<td align="center">
        					6<BR>13:10
        				</td>
        			
        				<td align="center">
        					7<BR>14:10
        				</td>
        			
        				<td align="center">
        					8<BR>15:10
        				</td>
        			
        				<td align="center">
        					9<BR>16:10
        				</td>
        			
        				<td align="center">
        					10<BR>17:10
        				</td>
        			
        				<td align="center">
        					11<BR>18:10
        				</td>
        			
        				<td align="center">
        					12<BR>19:10
        				</td>
        			
        				<td align="center">
        					13<BR>20:10
        				</td>
        			
        		</tr>
        		
        			<tr class="date">
        				<td class="view">
        					
        						04月15日<br>
        						(木)
        					
        					
        					
        				</td>
        				
        					
        					
        					
        					
        						<td class="status8">&nbsp;</td>
        					
        					
        				
        					
        					
        					
        					
        						<td class="status8">&nbsp;</td>
        					
        					
        				
        					
        					
        					
        					
        						<td class="status8">&nbsp;</td>
        					
        					
        				
        					
        					
        					
        					
        						<td class="status8">&nbsp;</td>
        					
        					
        				
        					
        					
        					
        					
        						<td class="status8">&nbsp;</td>
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status1"> 式</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        			</tr>
        		
        			<tr class="date">
        				<td class="view">
        					
        						04月16日<br>
        						(金)
        					
        					
        					
        				</td>
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        					
        					
        					
        						<td class="status3">ＡＴ模擬</td>
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> 式</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        			</tr>
        		
        			<tr class="date">
        				<td class="view">
        					
        					
        						<font color="#0000FF">
        							04月17日<br>
        							(土)
        						</font>
        					
        					
        				</td>
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> 式</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        			</tr>
        		
        			<tr class="date">
        				<td class="view">
        					
        					
        					
        						<font color="#FF0000">
        							04月18日<br>
        							(日)
        						</font>
        					
        				</td>
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> 式</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        			</tr>
        		
        			<tr class="date">
        				<td class="view">
        					
        						04月19日<br>
        						(月)
        					
        					
        					
        				</td>
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> 式</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        			</tr>
        		
        			<tr class="date">
        				<td class="view">
        					
        						04月20日<br>
        						(火)
        					
        					
        					
        				</td>
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> 式</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        					
        					
        					
        						<td class="status3">ＡＴ限１</td>
        					
        					
        				
        					
        						<td class="status0"> 8   </td>
        					
        					
        					
        					
        					
        				
        			</tr>
        		
        			<tr class="date">
        				<td class="view">
        					
        						04月21日<br>
        						(水)
        					
        					
        					
        				</td>
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> 式</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> &nbsp;</td>
        					
        					
        					
        					
        					
        				
        					
        						<td class="status0"> 9   </td>
        					
        					
        					
        					
        					
        				
        			</tr>
        		
        	</table>
        	<table class="set" cellspacing="0">
        		<tr>
        			<td align="left" bgcolor="#FFFFFF" width="17%">
        				
        					<a href="#" onclick="sendLink('N',document.getElementById('formId'))"><img src="/common/img/next.png" alt="次週へ" border="0"></a>
        				
        			</td>
        		</tr>
        	</table>
        </td>

        <!--３列目　生徒情報-->
        <td class="rightMenu">
        	



        <table class="student">
        	<tr>
        		<td class="bglightblue">教習生</td>
        	</tr>
        	<tr>
        		<td class="right">
        			<font color="#3366FF" size="2">03744 山本  敬太様</font><br>
        			<font color="#333333" size="2">希望免許 普通ＡＴ</font><br>
        			<font color="#333333" size="2">乗車時限 1段階 0時限乗車済</font><br><br>
        			<font color="#333333" size="2">所持免許 なし    </font><br><br>
        			<font color="#333333" size="2"></font><br>
        			<font color="#333333" size="2"></font>
        		</td>
        	</tr>
        </table>
        	<hr>
        	<table cellspacing="0">
        		<tr>
        			<td align="left">
        				<font size="2" color="#333333"><b>予約状況の見方</b></font>
        			</td>
        		</tr>
        	</table>
        	<table>
        		
        			
        				<tr>
        					<td width="30">
        						<img src="/common/img/button-status0.png" height="26" width="30">
        					</td>
        					<td valign="bottom" bgcolor="#FFFFFF" align="left">
        						<font size="1" color="#333333">空き無し</font>
        					</td>
        				</tr>
        			
        		
        			
        				<tr>
        					<td width="30">
        						<img src="/common/img/button-status1.png" height="26" width="30">
        					</td>
        					<td valign="bottom" bgcolor="#FFFFFF" align="left">
        						<font size="1" color="#333333">予約可能</font>
        					</td>
        				</tr>
        			
        		
        			
        		
        			
        				<tr>
        					<td width="30">
        						<img src="/common/img/button-status3.png" height="26" width="30">
        					</td>
        					<td valign="bottom" bgcolor="#FFFFFF" align="left">
        						<font size="1" color="#333333">予約済み</font>
        					</td>
        				</tr>
        			
        		
        			
        		
        			
        		
        			
        		
        			
        		
        			
        		
        			
        		
        	</table>
        </td>

        			
        		</tr>
        	</table>
        <input type="hidden" name="b.schoolCd" value="zA5IKlz+5to+brGQYS+1OA==" id="formId_b_schoolCd"/>
        <input type="hidden" name="b.processCd" value="" id="processCd"/>
        <input type="hidden" name="b.kamokuCd" value="0" id="kamokuCd"/>
        <input type="hidden" name="b.lastScreenCd" value="" id="formId_b_lastScreenCd"/>
        <input type="hidden" name="b.instructorTypeCd" value="0" id="formId_b_instructorTypeCd"/>
        <input type="hidden" name="b.dateInformationType" value="" id="date"/>
        <input type="hidden" name="b.infoPeriodNumber" value="" id="period"/>
        <input type="hidden" name="b.carModelCd" value="301" id="formId_b_carModelCd"/>
        <input type="hidden" name="b.instructorCd" value="0" id="formId_b_instructorCd"/>
        <input type="hidden" name="b.page" value="1" id="formId_b_page"/>
        <input type="hidden" name="b.groupCd" value="1" id="formId_b_groupCd"/>
        <input type="hidden" name="b.changeInstructorFlg" value="1" id="formId_b_changeInstructorFlg"/>

        <input type="hidden" name="b.nominationInstructorCd" value="0" id="formId_b_nominationInstructorCd"/>
        <input type="hidden" name="upDate" value="1618456644578"/>
        </form>



        					</td>
        				</tr>
        				<tr class="bgcolor" valign="bottom" align="right">
        					
        <td>
        	<font size="2">[powered by e-license.jp]</font>
        </td>
        				</tr>
        			</table>
        		</td>
        	</tr>
        </table>
        </body>
        </html>

    """.trimIndent()
}