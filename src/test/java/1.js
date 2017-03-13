(function () {
    try {
        var imgs = '';
        for (var i = 0; i < imgData.img.length; i += 1) {
            imgs += imgData.img[i].title + '<a href=\"' + imgData.img[i].img_url + '\"></a>';
        }
        return imgs;
    } catch (e) {
        if (document.getElementById('text')) {
            if (document.getElementById('adPp')) {
                var val = document.getElementById('adPp').innerHTML;
                return document.getElementById('text').innerHTML.replace(val, '').split('<script')[0]
            } else {
                return document.getElementById('text').innerHTML.split('<script')[0]
            }
        } else {
            return document.getElementsByClassName('mod')[0].innerHTML.split('<script') [0];
        }
    }
})()
