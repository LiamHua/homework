function getCookie(name) {
    var cookies = document.cookie;
    var list = cookies.split("; ");

    for (var i = 0; i < list.length; i++) {
        var arr = list[i].split("=");
        if (arr[0] == name) {
            console.log(decodeURIComponent(arr[1]))
            return decodeURIComponent(arr[1]);
        }
    }
    return "";
}

// 获取cookie中的name，并设置记住用户名为选中状态
var name = getCookie("name")
if (name !== "") {
    document.getElementById("username").value = name
    document.getElementById("remember-me").checked = true
}


