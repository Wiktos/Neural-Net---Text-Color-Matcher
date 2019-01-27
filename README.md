# Neural-Net-Text-Color-Matcher
My first, programmed from the very beginning, neural network which can match text color for a given RGB background. 
Software was based on Model-View-Controller design pattern. Model contains hole implementation of Neural Net
, which structure is drawn below. Controller provides connection of Model(NeuralNet) and View. The connection is realised via boundaries
, which in case of my aplication were reasised via Java interfaces.

## Program Overview
![alt text](https://t4zdoq.db.files.1drv.com/y4maZ2tUzJU3O-o78S8U8FXcFFvDI1eCyZZ7yF2nygqYNG-MusMk-wKBPdssc3KxJ21fypNRcNBGovSPq16eE6-9XIY2RuCPBW2U6u6sWgprngAUmM1ss4iHCgEXnfCZnNGlYc_-cTAkc-cJcKpPUgdxNfQySnpSr8SrFGEUgm1iIQhdYfxLmS6NhoFK2S2REikChYWbxifg2UYsjPAHSRGLw/overview.gif?download&psid=1)

## Neural Net used - Diagram
![alt text](https://db3pap002files.storage.live.com/y4mUePuxPnTNRes30qOLDN-TjO_IPI_kt2d0KdJo8no2-iLGVmf2nTMc5_xf0UOhLULzh3cJjsZtcsBtRxsPgCCdXc4KYaQ6Jl8Fv6aTf8RtlqcW5yPFUfQqfhGKKQ0Ji7u3lD82U02iAWcb4RmRcR_43U7A06XvBaeIDDMofznwtBEyrn4pIHszNt4lvb62Nf_2TTYnFqFris4Tm_bIx4h9w/net.JPG?psid=1&width=928&height=310)

**Input layer** - we fill with RGB values.

**Output layer** - contains the prediction of color. If the first node of this layer is active than predicted color is black. Otherwise, if the
second node of that layer is active than predicted color is white.

## Software UML *Class Diagram* - Model
![alt text](https://db3pap002files.storage.live.com/y4mpZIL0KL3XD26eq3XyzM_zpQeY8MhUJHlYZoXvDnPakSer1WhqUcHqIdWkW-7Xj6y4F34a7ArLFWWV7oYJTgLtMfen8PBioRFKCsrntaWGDHZ031Nmnlwq13XxC29bWPiq1AHi2ay5JjNsGf49lwsbDp5AZurN5kQZFBq-rmoTddvtn9F6m2OfycUru9OgYpf5vTG002wX2veUTiIS7JQQQ/Model__Model_0.jpg?psid=1&width=976&height=848)

## Software UML *Class Diagram* - Controller
![alt text](https://db3pap002files.storage.live.com/y4mq4EI3JWhBJbh8TWQ7uJzp5cgycgo8lOjBDGuJkUMGdVAnmVYpgCUtg_ZIpuv1hzd7P1IaqwzKfy6VjFKM179wIqHWKluxbAkbzXdnbHxnXmytdzsbyXx59nZS0MJXcHxUuBibdDvhGZURoAtQO03E0NsC7omIYsaN5XAkLRoXKSX5NTGj_oOcTqvfnu4_17Kp4NLS_TGR4gDbTZgmwiSUg/Controller__Controller_1.jpg?psid=1&width=943&height=490)

**_AI_** - is an interface that is implemented by NeuralNet from Model module.

**_ThinkablePanel_** is an interface that is implemeted by *ThinkPanel* from View module.

**_ColorInputable_** is an interface that is implemeted by *InputPanel* from View module.

## Software UML *Class Diagram* - View
![alt text](https://db3pap002files.storage.live.com/y4m0n0f073hlI0SJ39dKyJNcQPvgirqBb8J8Nno-JYapmbq4RpOX3OG-aegLCSk8U0hOf5rsClfb_nQLeCR4vugWZK2rg-4xbByvJPi9OOWheeR5OUWvEEs5oLqGfDIAmOVIk1x8HaDb4nal2ECnuJxRGS2-qAkt802WrvLcRj-P9eShOyJm0znLUbS4flFUpKkOW9UrHF383jD-aNQeKBbhw/View__View_2.jpg?psid=1&width=842&height=769)
