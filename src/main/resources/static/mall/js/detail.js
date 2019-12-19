function initFile(fo){
    var divFile = document.createElement("div");
    divFile.className="file";
    fo.parentNode.insertBefore(divFile,fo);
    divFile.appendChild(fo);
    var  btnRemove = document.createElement("button");
    btnRemove.className="remove";
    btnRemove.type="button";
    btnRemove.innerHTML="移除";
    divFile.insertBefore(btnRemove,fo);
    var  btnUpload = document.createElement("button");
    btnUpload.className="upload";
    btnUpload.innerHTML="选择图片";
    btnUpload.type="button";
    divFile.insertBefore(btnUpload,btnRemove);
    var  showImgTar = document.createElement("img");
    showImgTar.setAttribute('src','../image/add_img.png');
    showImgTar.setAttribute('width','150');
    showImgTar.setAttribute('height','150');
    divFile.insertBefore(showImgTar,btnUpload);
}
var inputFiles = document.querySelectorAll("input[type='file']");
inputFiles.forEach(function(inf){
    initFile(inf);
})
//file onload
var upload = document.querySelectorAll(".upload");
var file = document.querySelectorAll(".file");
file.forEach(function(f){
    var showImg = f.querySelector("img");
    var defImgSrc = ".../imageadd_img.png";
    var inpFile = f.querySelector("input[type='file']");
//移除
    f.querySelector(".remove").onclick = function(){
        showImg.src=defImgSrc;
        inpFile.value="";
    }
//上传
    f.querySelector(".upload").onclick = function(){
        f.querySelector("input[type='file']").click();
    }
    inpFile.onchange = function(){

//判断文件大小
        var fileSize = 1024 * 1024 * 1;
        if(this.files[0].size>=fileSize){
            alert("图片过大,请上传小于1M的图片");
            this.value="";
            return;
        }
//创建fileReader对象
        var reader =  new FileReader();
//图片编码完成
        reader.onloadend = function(e){
            showImg.src = e.target.result;
        }
        //解析图片 成base 64位的图片 用fileReader的readAsDataURL 去读本地图片对象
        reader.readAsDataURL(this.files[0]);
    }
})


