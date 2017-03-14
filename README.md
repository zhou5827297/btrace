# 测试代码
kafka，selenium，storm，imagedeal，btrace，kaptcha

# kafka
实现简单的log推送，消费

# selenium
WebDriver调用phantomjs

# storm
统计单次出现频率

# imageio
java进行图片裁剪

# btrace
动态追踪诊断

# mybatis
分页器

# kaptcha
kaptcha 是一个非常实用的验证码生成工具。有了它，你可以生成各种样式的验证码，因为它是可配置的  

* 验证码的字体
* 验证码字体的大小
* 验证码字体的字体颜色
* 验证码内容的范围(数字，字母，中文汉字！)
* 验证码图片的大小，边框，边框粗细，边框颜色
* 验证码的干扰线(可以自己继承com.google.code.kaptcha.NoiseProducer写一个自定义的干扰线)
* 验证码的样式(鱼眼样式、3D、普通模糊……当然也可以继承com.google.code.kaptcha.GimpyEngine自定义样式)

配置如下：  

| Constant      | description   | default|
| :-----------: |---------------| ------ |
|kaptcha.border	|图片边框，合法值：yes , no	|yes|
|kaptcha.border.color	|边框颜色，合法值： r,g,b (and optional alpha) 或者 white,black,blue.	|black|
|kaptcha.border.thickness	|边框厚度，合法值：>0	|1|
|kaptcha.image.width	|图片宽	|200|
|kaptcha.image.height	|图片高	|50|
|kaptcha.producer.impl	|图片实现类	|com.google.code.kaptcha.impl.DefaultKaptcha|
|kaptcha.textproducer.impl	|文本实现类	|com.google.code.kaptcha.text.impl.DefaultTextCreator|
|kaptcha.textproducer.char.string	|文本集合，验证码值从此集合中获取	|abcde2345678gfynmnpwx|
|kaptcha.textproducer.char.length	|验证码长度	|5|
|kaptcha.textproducer.font.names	|字体	|Arial, Courier|
|kaptcha.textproducer.font.size	|字体大小	|40px.|
|kaptcha.textproducer.font.color	|字体颜色，合法值： r,g,b  或者 white,black,blue.	|black|
|kaptcha.textproducer.char.space	|文字间隔	|2|
|kaptcha.noise.impl	|干扰实现类	|com.google.code.kaptcha.impl.DefaultNoise|
|kaptcha.noise.color	|干扰颜色，合法值： r,g,b 或者 white,black,blue.	|black|
|kaptcha.obscurificator.impl	|图片样式：  <br>水纹com.google.code.kaptcha.impl.WaterRipple<br>  鱼眼com.google.code.kaptcha.impl.FishEyeGimpy<br>  阴影com.google.code.kaptcha.impl.ShadowGimpy|	com.google.code.kaptcha.impl.WaterRipple|
|kaptcha.background.impl	|背景实现类	com.google.code.kaptcha.impl.DefaultBackground|
|kaptcha.background.clear.from	|背景颜色渐变，开始颜色	|light grey|
|kaptcha.background.clear.to	|背景颜色渐变，结束颜色	|white|
|kaptcha.word.impl	|文字渲染器|	com.google.code.kaptcha.text.impl.DefaultWordRenderer|
|kaptcha.session.key	|session key	|KAPTCHA_SESSION_KEY|
|kaptcha.session.date	|session date|	KAPTCHA_SESSION_DATE|


# 问题反馈
在使用中有任何问题，欢迎反馈给我，可以用以下联系方式跟我交流

* 邮件: (zhou5827297@163.com)
