// 打印标签模板
var model = 'PGRpdiBjbGFzcz0iYm94IiBhdHI9J2F0cl9ib3gnPg0KICAgIDxkaXYgY2xhc3M9InRpdGxlIGNsZWFyZml4Ij4NCiAgICAgICAgPGRpdj4NCiAgICAgICAgICAgIDxoMj7mlLbmrL7mlbDmja48L2gyPg0KICAgICAgICA8L2Rpdj4NCiAgICAgICAgPHAgYXRyPSJhdHJfc25vIj48L3A+DQogICAgPC9kaXY+DQogICAgPGRpdiBjbGFzcz0ic3ViX3RpdGxlIGNsZWFyZml4Ij4NCiAgICAgICAgPGgzPuWuouaIt+WQjeensO+8mjwvaDM+DQogICAgICAgIDxzcGFuIGF0cj0iYXRyX25hbWUiPjwvc3Bhbj4NCiAgICAgICAgPHAgYXRyPSJhdHJfZGF0ZSI+PC9wPg0KICAgIDwvZGl2Pg0KICAgIDxkaXYgY2xhc3M9InByaW50IGNsZWFyZml4Ij4NCiAgICAgICAgPHRhYmxlIGNsYXNzPSJ0YWIxIj4NCiAgICAgICAgICAgIDx0aGVhZD4NCiAgICAgICAgICAgIDx0cj4NCiAgICAgICAgICAgICAgICA8dGggY2xhc3M9Iml0ZW0iPui0p+WPtzwvdGg+DQogICAgICAgICAgICAgICAgPHRoIGNsYXNzPSJicmFuZCI+5ZOB5ZCN5Y+K6KeE5qC8PC90aD4NCiAgICAgICAgICAgICAgICA8dGggY2xhc3M9Iml0ZW0iPuWNleS9jTwvdGg+DQogICAgICAgICAgICAgICAgPHRoIGNsYXNzPSJudW1iZXIiPuaVsOmHjzwvdGg+DQogICAgICAgICAgICAgICAgPHRoIGNsYXNzPSJudW1iZXIiPuWNleS7tzwvdGg+DQogICAgICAgICAgICAgICAgPHRoIGNsYXNzPSJrb25nIj48L3RoPg0KICAgICAgICAgICAgPC90cj4NCiAgICAgICAgICAgIDwvdGhlYWQ+DQogICAgICAgICAgICA8dGJvZHk+DQogICAgICAgICAgICA8dHI+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkIGF0cj0iYXRyX2dnIj7mtYvor5Xlk4HlkI3lj4rop4TmoLw8L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgPC90cj4NCiAgICAgICAgICAgIDx0cj4NCiAgICAgICAgICAgICAgICA8dGQ+PC90ZD4NCiAgICAgICAgICAgICAgICA8dGQ+PC90ZD4NCiAgICAgICAgICAgICAgICA8dGQ+PC90ZD4NCiAgICAgICAgICAgICAgICA8dGQ+PC90ZD4NCiAgICAgICAgICAgICAgICA8dGQ+PC90ZD4NCiAgICAgICAgICAgICAgICA8dGQ+PC90ZD4NCiAgICAgICAgICAgIDwvdHI+DQogICAgICAgICAgICA8dHI+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICA8L3RyPg0KICAgICAgICAgICAgPHRyPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgPC90cj4NCiAgICAgICAgICAgIDx0cj4NCiAgICAgICAgICAgICAgICA8dGQ+PC90ZD4NCiAgICAgICAgICAgICAgICA8dGQ+PC90ZD4NCiAgICAgICAgICAgICAgICA8dGQ+PC90ZD4NCiAgICAgICAgICAgICAgICA8dGQ+PC90ZD4NCiAgICAgICAgICAgICAgICA8dGQ+PC90ZD4NCiAgICAgICAgICAgICAgICA8dGQ+PC90ZD4NCiAgICAgICAgICAgIDwvdHI+DQogICAgICAgICAgICA8dHIgY2xhc3M9InRvdGFsIj4NCiAgICAgICAgICAgICAgICA8dGQgY2xhc3M9InRvdGFsIj7lkIjorqEgPHA+5Lq65rCR5biBPC9wPiA8L3RkPg0KICAgICAgICAgICAgICAgIDx0ZCBjb2xzcGFuPSI0Ij4NCiAgICAgICAgICAgICAgICAgICAgJm5ic3A7Jm5ic3A7PHNwYW4gYXRyPSJhdHJfcm1iX2E5Ij4mbmJzcDs8L3NwYW4+PHNwYW4gYXRyPSJhdHJfcm1iX2I5Ij4mbmJzcDs8L3NwYW4+5LufPHNwYW4gYXRyPSJhdHJfcm1iX2E4Ij4mbmJzcDs8L3NwYW4+PHNwYW4gYXRyPSJhdHJfcm1iX2I4Ij4mbmJzcDs8L3NwYW4+5L2wPHNwYW4gYXRyPSJhdHJfcm1iX2E3Ij4mbmJzcDs8L3NwYW4+PHNwYW4gYXRyPSJhdHJfcm1iX2I3Ij4mbmJzcDs8L3NwYW4+5ou+PHNwYW4gYXRyPSJhdHJfcm1iX2E2Ij4mbmJzcDs8L3NwYW4+PHNwYW4gYXRyPSJhdHJfcm1iX2I2Ij4mbmJzcDs8L3NwYW4+5LiHPHNwYW4gYXRyPSJhdHJfcm1iX2E1Ij4mbmJzcDs8L3NwYW4+PHNwYW4gYXRyPSJhdHJfcm1iX2I1Ij4mbmJzcDs8L3NwYW4+5LufPHNwYW4gYXRyPSJhdHJfcm1iX2E0Ij4mbmJzcDs8L3NwYW4+PHNwYW4gYXRyPSJhdHJfcm1iX2I0Ij4mbmJzcDs8L3NwYW4+5L2wPHNwYW4gYXRyPSJhdHJfcm1iX2EzIj4mbmJzcDs8L3NwYW4+PHNwYW4gYXRyPSJhdHJfcm1iX2IzIj4mbmJzcDs8L3NwYW4+5ou+PHNwYW4gYXRyPSJhdHJfcm1iX2EyIj4mbmJzcDs8L3NwYW4+PHNwYW4gYXRyPSJhdHJfcm1iX2IyIj4mbmJzcDs8L3NwYW4+5YWDPHNwYW4gYXRyPSJhdHJfcm1iX2ExIj4mbmJzcDs8L3NwYW4+PHNwYW4gYXRyPSJhdHJfcm1iX2IxIj4mbmJzcDs8L3NwYW4+6KeSPHNwYW4gYXRyPSJhdHJfcm1iX2EwIj4mbmJzcDs8L3NwYW4+PHNwYW4gYXRyPSJhdHJfcm1iX2IwIj4mbmJzcDs8L3NwYW4+5YiGPC90ZD4NCiAgICAgICAgICAgICAgICA8dGQ+PC90ZD4NCiAgICAgICAgICAgIDwvdHI+DQogICAgICAgICAgICA8L3Rib2R5Pg0KICAgICAgICA8L3RhYmxlPg0KICAgICAgICA8dGFibGUgY2xhc3M9InRhYjIiPg0KICAgICAgICAgICAgPHRoZWFkPg0KICAgICAgICAgICAgPHRyPg0KICAgICAgICAgICAgICAgIDx0aCBjbGFzcz0iYW1vdW50IiBjb2xzcGFuPSIxMCI+6YeRJm5ic3A7Jm5ic3A7Jm5ic3A7Jm5ic3A7Jm5ic3A7Jm5ic3A76aKdPC90aD4NCiAgICAgICAgICAgIDwvdHI+DQogICAgICAgICAgICA8L3RoZWFkPg0KICAgICAgICAgICAgPHRib2R5Pg0KICAgICAgICAgICAgPHRyPg0KICAgICAgICAgICAgICAgIDx0ZCBjbGFzcz0iZGF0YSI+5Y2DPC90ZD4NCiAgICAgICAgICAgICAgICA8dGQgY2xhc3M9ImRhdGEiPueZvjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkIGNsYXNzPSJkYXRhIj7ljYE8L3RkPg0KICAgICAgICAgICAgICAgIDx0ZCBjbGFzcz0iZGF0YSI+5LiHPC90ZD4NCiAgICAgICAgICAgICAgICA8dGQgY2xhc3M9ImRhdGEiPuWNgzwvdGQ+DQogICAgICAgICAgICAgICAgPHRkIGNsYXNzPSJkYXRhIj7nmb48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZCBjbGFzcz0iZGF0YSI+5Y2BPC90ZD4NCiAgICAgICAgICAgICAgICA8dGQgY2xhc3M9ImRhdGEiPuWFgzwvdGQ+DQogICAgICAgICAgICAgICAgPHRkIGNsYXNzPSJkYXRhIj7op5I8L3RkPg0KICAgICAgICAgICAgICAgIDx0ZCBjbGFzcz0iZGF0YSI+5YiGPC90ZD4NCiAgICAgICAgICAgIDwvdHI+DQogICAgICAgICAgICA8dHI+DQogICAgICAgICAgICAgICAgPHRkIGF0cj0iYXRyX3JfOSI+PC90ZD4NCiAgICAgICAgICAgICAgICA8dGQgYXRyPSJhdHJfcl84Ij48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZCBhdHI9ImF0cl9yXzciPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkIGF0cj0iYXRyX3JfNiI+PC90ZD4NCiAgICAgICAgICAgICAgICA8dGQgYXRyPSJhdHJfcl81Ij48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZCBhdHI9ImF0cl9yXzQiPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkIGF0cj0iYXRyX3JfMyI+PC90ZD4NCiAgICAgICAgICAgICAgICA8dGQgYXRyPSJhdHJfcl8yIj48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZCBhdHI9ImF0cl9yXzEiPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkIGF0cj0iYXRyX3JfMCI+PC90ZD4NCiAgICAgICAgICAgIDwvdHI+DQogICAgICAgICAgICA8dHI+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICA8L3RyPg0KICAgICAgICAgICAgPHRyPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgPC90cj4NCiAgICAgICAgICAgIDx0cj4NCiAgICAgICAgICAgICAgICA8dGQ+PC90ZD4NCiAgICAgICAgICAgICAgICA8dGQ+PC90ZD4NCiAgICAgICAgICAgICAgICA8dGQ+PC90ZD4NCiAgICAgICAgICAgICAgICA8dGQ+PC90ZD4NCiAgICAgICAgICAgICAgICA8dGQ+PC90ZD4NCiAgICAgICAgICAgICAgICA8dGQ+PC90ZD4NCiAgICAgICAgICAgICAgICA8dGQ+PC90ZD4NCiAgICAgICAgICAgICAgICA8dGQ+PC90ZD4NCiAgICAgICAgICAgICAgICA8dGQ+PC90ZD4NCiAgICAgICAgICAgICAgICA8dGQ+PC90ZD4NCiAgICAgICAgICAgIDwvdHI+DQogICAgICAgICAgICA8dHI+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICAgICAgPHRkPjwvdGQ+DQogICAgICAgICAgICA8L3RyPg0KICAgICAgICAgICAgPHRyPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgICAgIDx0ZD48L3RkPg0KICAgICAgICAgICAgPC90cj4NCiAgICAgICAgICAgIDwvdGJvZHk+DQoNCiAgICAgICAgPC90YWJsZT4NCiAgICA8L2Rpdj4NCiAgICA8dWwgY2xhc3M9ImNsZWFyZml4Ij4NCiAgICAgICAgPGxpPuWhq+elqO+8mjwvbGk+DQogICAgICAgIDxsaT7mlLbmrL7kurrvvJo8c3BhbiBhdHI9ImF0cl9yZWNlaXZlciI+5aes5Lya6K6hPC9zcGFuPjwvbGk+DQogICAgICAgIDxsaT7kvJrorqHvvJo8L2xpPg0KICAgICAgICA8bGk+5pS25qy+5Y2V5L2N77yaPC9saT4NCiAgICA8L3VsPg0KPC9kaXY+';
// 初始化数字
var initNum = 0;

// 打印预览
function print() {
    $("#print").jqprint();
}


// 生成打印格式总入口
function csv(){
    // 清空打印区域
    $("#print").html('');
    // CSV文件转换成打印标签
    $("input[name=csvfile]").csv2arr(function(arr){
        // 循环整个CSV文件，获得每一行信息
        $.each( arr, function(i, line){
            // 组装要打印的标签
            var $bodyMainTxt = jointLabel(line);
            // 偶数页，打印分页
            if (i % 2 != 0) {
                $bodyMainTxt.css('page-break-after', 'always');
            }
            $('#print').append($bodyMainTxt);
        });
    });
}

// 格式化日期
function exchangeDate(date) {
    if (date == null || date.length == 0) {
        return '';
    }
    // 先截取前8位做为备份
    var subsDate = date.substr(0, 8);
    // 年
    var year = '';
    // 月
    var month = '';
    // 日
    var day = '';

    date = new Date(date);
    // 无效的日期格式，手动截取字符串
    if (date.toLocaleDateString() == 'Invalid Date') {
        year = subsDate.substr(0, 4);
        month = subsDate.substr(4, 2);
        day = subsDate.substr(6, 2);

        return year + '年' + month + '月' + day + '日';
        // 有效的日期格式
    } else {
        year = date.getFullYear();
        month = date.getMonth() + 1;
        day = date.getDate();
        if (month < 10) {
            month = '0' + month;
        }
        if (day < 10) {
            day = '0' + day;
        }
        return year + "年" + month + "月" + day + "日";
    }
}

// 组装金钱标签
function joinMoney(money, $bodyMainTxt) {
    if (money == null || money == '') {
        return $bodyMainTxt;
    }

    var strOutUnit = '零壹贰叁肆伍陆柒捌玖';

    money += '00';
    var pointPos = money.indexOf('.');
    // 如果没有.点的话，那么整数+2位小数拼接就可以了
    if (pointPos > 0) {
        money = money.substring(0, pointPos) + money.substr(pointPos + 1, 2);
    }

    for (var i = 0; i < money.length; i++) {
        var j = money.length - i - 1;
        // 当前位的值
        var v = money.substr(i, 1);
        // 当前位置的大写的值
        var vbig = strOutUnit.substr(v, 1);
        // 大写羊角属性
        var atrYj = 'atr_rmb_b' + (j + 1);
        // b属性
        var atrb = 'atr_rmb_b' + j;
        // 小写羊角属性
        var attrYj = 'atr_r_' + (j + 1);
        // 小写属性
        var atrr = 'atr_r_' + j;

        if (i == 0) {
            // 人民币+大写
            $bodyMainTxt.find('[atr=' + atrYj + ']').html('¥');
            $bodyMainTxt.find('[atr=' + atrb + ']').html(vbig);
            // 人民币+小写
            $bodyMainTxt.find('[atr=' + attrYj + ']').html('¥');
            $bodyMainTxt.find('[atr=' + atrr + ']').html(v);
        } else {
            // 大写
            $bodyMainTxt.find('[atr=' + atrb + ']').html(vbig);
            // 小写
            $bodyMainTxt.find('[atr=' + atrr + ']').html(v);
        }

    }
    return $bodyMainTxt;
}

// 拼接打印标签
function jointLabel(line) {
    // 获取要打印的主体信息,jquery对象
    var $bodyMainTxt = initBodyMain();
    // 编号
    var sno = generatorSno();
    // 名称
    var name = line[3];
    // 日期
    var date = exchangeDate(line[0]);
    // 品名及规格
    var gg = line[1];
    // 金额
    var money = line[2];
    if (money != null && money != '') {
        // 去掉空格
        money = $.trim(money);
        // 去掉中间的逗号
        money = money.replace(/[,]/g, '');
    }
    // 组装金钱标签
    $bodyMainTxt = joinMoney(money, $bodyMainTxt);
    // 组装编号
    $bodyMainTxt.find('[atr=atr_sno]').html(sno);
    // 组装名称
    $bodyMainTxt.find('[atr=atr_name]').html(name);
    // 组装日期
    $bodyMainTxt.find('[atr=atr_date]').html(date);
    // 组装品名及规格
    $bodyMainTxt.find('[atr=atr_gg]').html(gg);
    return $bodyMainTxt;
}

// 获取编号
function generatorSno() {
    var sno = window.localStorage.getItem('sno');
    // 初始化编号
    if (sno == null || sno == '') {
        var initSno = 11111111;
        var date = new Date();
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var day = date.getDate();
        if (month < 10) {
            month = '0' + month;
        }
        if (day < 10) {
            day = '0' + day;
        }
        var all = year + month + day;

        sno = (initSno + parseInt(all)) + '';
    }
    // 生成新编号存入本地
    var newSno = parseInt(sno) + 1;
    window.localStorage.setItem('sno', newSno + '');
    return sno;
}

// 返回组装打印主体，jQuery对象
function initBodyMain() {
    // 获取模板
    var bodyMainObj = $.base64.decode(model);
    // 模板内容转换成jQuery对象
    var $jqBodyMain = $(bodyMainObj);

    return $jqBodyMain;
}