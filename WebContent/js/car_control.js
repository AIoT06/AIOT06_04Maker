$(document).ready(function(){
$(function(){

            $(document).keydown(function(event){
                let keyNum = event.which;  //獲取鍵值
                console.log(keyNum)
               
                switch(keyNum){    //判斷按鍵
                case 37:   //window.location.href='/' + "L" ; 
                            $("#L").css('color' ,'green');
                            break ;     //左
                case 38:   //window.location.href='/' + "F" ; 
                            $("#F").css('color' ,'green');
                            break ;      //上         
                case 39:   //window.location.href='/' + "R" ; 
                            $("#R").css('color' ,'green');
                            break ;      //右
                case 40:   //window.location.href='/' + "B" ;
                            $("#B").css('color' ,'green');
                            break ;       //下
                default:
                } //Switch 結束

            })  //keydown事件結束

            $(document).keyup(function(event){
                let keyNum = event.which;  //獲取鍵值
                // console.log(keyNum)
                //window.location.href='/' + "S" ;
                $("#B").css('color' ,'white');
            })
           
        }) //jQuary 結束
})

function carControl(key) {
    console.log(key);
}