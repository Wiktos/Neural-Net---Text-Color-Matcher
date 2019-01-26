# Neural-Net-Text-Color-Matcher
My first, programmed from the very beginning, neural network which can match text color for a given RGB background. 
Software was based on Model-View-Controller design pattern. Model contains hole implementation of Neural Net
, which structure is drawn below. Controller provides connection of Model(NeuralNet) and View. The connection is realised via boundaries
, which in case of my aplication were reasised via Java interfaces.

## Program Overview
![alt text](https://jlygtg.db.files.1drv.com/y4ma1P--LTuYUXYnJNWiWlQtz5gOw42wgzZuABvvEZLuyzA2X8Hc5UA3dOdVYIhNSHvP1JzyjJze4_AcEeNMS9jXSLO42vmuu6XhtN6ANwUy4h0yUCx5bXZxoNBIKCV7VwP4yuWy6K2QIjhGfLAuOgBH5XeyMJKs34dJe06W95p8BXyoGkfxzd3v4siGG_Kw8IMchCNgIUSswcb_wCKcV88aQ/NeuralNetOver.gif?download&psid=1)

## Neural Net used - Diagram
![alt text](https://db3pap002files.storage.live.com/y4m3mwm_2IaGQfFWatTSsQwlXPD1dU5qjtbGMex2kKNK9StLmgaFgn7f252hTd8jveYMewrOn890d5wxIBm_T3uE1jK4gs8u_YnT1S40NCY6EEQEbkkCinOT3u05VYYXtbqtDVAN_Fb2XhaTn96GyQgYGAOha78Q6w--kAST3FUEVAdeF9EiA_3RcnAcuCY4LDuNvE7nVIPKnid5kCHsTga2Q/neuralnetimg.JPG?psid=1&width=951&height=328)

**Input layer** - we fill with RGB values.

**Output layer** - contains the prediction of color. If the first node of this layer is active than predicted color is black. Otherwise, if the
second node of that layer is active than predicted color is white.

## Software UML *Class Diagram* - Model
![alt text](https://db3pap002files.storage.live.com/y4mGxebllsJkJnagY5DyGtub0R5vjTFv66Fz4MNog6I2m20UhgVD2I84lbaI0GCLmPOA8NRBJqFjSudzNN7_wiwS63Y2iQq3_WqaDtiR0SUITk86-nQcjIPFL0z2F0J5hx6RsKIHHfzRUhI_tiiKUr88ISQZN2vo2uDuo7vNlew3o8rYAVBbKcnkInFCuprBqtRrcWhEhPFxFf5OZmLJJj-yw/NeuralNetModel.jpg?psid=1&width=943&height=820)

## Software UML *Class Diagram* - Controller
![alt text](https://db3pap002files.storage.live.com/y4m_i5A6GdtkisY3Yz84TP1CsbT1lU8ziNUBg-rw3dbaGOUVwST4HfSNvL2YgylAMckTR5GUA_xxJ5ChXfAD8HyA6vOm4kT19PfSP34YXNk6jmo0YkUQUk9l2SKDDjBWufaDiKXkpk4SXn02HZkdSfulio0MnimnzvCXiCtpGXPy4JvJeWrdNkpQmNrgF780fG8SfFaAyMH4MwfGIt1T1AJNw/NeuralNetController.jpg?psid=1&width=943&height=490)

**_AI_** - is an interface that is implemented by NeuralNet from Model module.

**_ThinkablePanel_** is an interface that is implemeted by *ThinkPanel* from View module.

**_ColorInputable_** is an interface that is implemeted by *InputPanel* from View module.

## Software UML *Class Diagram* - View
![alt text](https://db3pap002files.storage.live.com/y4mAqbJYG6cn1QW8YC20SrECzqoiq2JIQy7G90unO-jkm3b5WxR2j0jC4ema1YqDaYAbYsJK_0gEelrtemk--d2SF2NUA2nvZAqxvBCeeZarhuXJpG3EqDZ5zx2FUv7vtMqojbD-YJNgDGCmszneugl5FHWCootQu-bGaUZ6_q-zTkiogi_aF8y0ZjS9-gu0UCfc0_iUlT8SjCWQTBqgrhtRQ/NeuralNetView.jpg?psid=1&width=842&height=769)
