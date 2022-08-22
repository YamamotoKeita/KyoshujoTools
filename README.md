A bot that periodically logs into my driving school's web page, scrapes it, and sends a Slack message of available reservations.

I got my driving license and I don't need it anymore.

# Login Page

https://www.e-license.jp/el25/?abc=zA5IKlz%2B5to%2BbrGQYS%2B1OA%3D%3D

# Login Request

## Request URL

https://www.e-license.jp/el25/pc/p01a.action

## Post Data

- b.studentId=<my student id>
- b.password=<my password>
- method:doLogin=%83%8D%83O%83C%83%93             ログイン(Shift_JIS)
- b.wordsStudentNo=%8B%B3%8FK%90%B6%94%D4%8D%86   教習生番号(Shift_JIS)
- b.processCd=
- b.kamokuCd=
- b.schoolCd=zA5IKlz%2B5to%2BbrGQYS%2B1OA%3D%3D
- index=
- server=qar004

## Required Request Headers

- Content-Length: 213
- Origin: https://www.e-license.jp
- Content-Type: application/x-www-form-urlencoded
- User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 11_2_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.114 Safari/537.36
- Cookie: (the followings)

## Request Cookies

JSESSIONID=716CB4524F6F0B4D54EB3D309BAB64BE.tomcat-ap2;
BIGipServerp-0b01-www.e-license.jp-443-3=739383724.20480.0000
BIGipServerp-0b01-www.e-license.jp-443-2=621943212.20480.0000

## Other Request Headers
Upgrade-Insecure-Requests: 1
Sec-Fetch-Site: same-origin
Sec-Fetch-Mode: navigate
Sec-Fetch-User: ?1
Sec-Fetch-Dest: document
Referer: https://www.e-license.jp/el25/?abc=zA5IKlz%2B5to%2BbrGQYS%2B1OA%3D%3D
Accept-Encoding: gzip, deflate, br
Accept-Language: ja,en-US;q=0.9,en;q=0.8

## Result

table のうち tr.carender を含むもの?  
tdのclassで空き状況が分かる

- status0: 空きなし
- status1: 空きあり
- status2: 不明
- status3: 自分が予約中

```html
<tbody>
	<tr class="carender">
		<td></td><td>08:10</td>....
	</tr>
	<tr>
		<td class="view">04月15日</td>...
	</tr>
	...
</tbody>
```

## 設計

- ログインして予約カレンダー取得
- 日付ごとに空き時間を記録
- 前回記録から新しい空きが増えていれば通知

## ストレージ
空き時間はJSONでファイルに保存

```json
[
  {"date": "04-15", "availableTimes": ["12:10"]},
  {"date": "04-16", "availableTimes": []}
]
```
