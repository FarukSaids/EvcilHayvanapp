package com.example.evcilhayvanapp

class AnimalDataGenerator {
    companion object {
    fun generateData(): List<animalsdata> {
        val isimler = arrayOf("Tekir", "van kedisi","İran Kedisi","Highlander")
        val resimler = arrayOf(R.drawable.background1, R.drawable.background2, R.drawable.napolyon_kedisi,R.drawable.highlanderr)
        val bilgiler = arrayOf("Sokaklarda en çok karşılaştığınız türdür.",
                                "bu hayvan evcil bir hayvandır",
                "KARAKTER  : Munchkin ve İran kedisi ırkları arasında melez bir cins kedi olan Napolyon, birçok cüce kedi ırklarından biri olarak karşımıza çıkmaktadır. " +
                        "Cüce boyu nedeniyle ünlü politikacı Napolyon Bonapart’a atıfta bulunarak isimlendirilen bu sevimli kedinin en iyi özelliklerinden bazıları sevgi dolu, " +
                        "oyuncu, uysal ve sahibine karşı son derece sadık olmasıdır. Kökeni, genel görünümü, beslenme ve sağlığı gibi başlıklara geçmeden önce sizlere bu şirin kedinin kişiliğinden bahsetmek istiyoruz…\n" +
                "\n" +
                "Onu ilk gördüğünüzde eminiz cüce boyuna, tatlı yüzüne ve uysal bakışlarına vurulacaksınızdır." +
                        " Tıpkı İran kedisi gibi uysal ve kalbinizi yumuşatacak uysal bakışlara sahiptir. Zaten mizaç olarak da İran kedisiyle benze özelliklere sahiptir;" +
                        " sevimli, uysal, iyi huylu ve sahibine sadık.\n" +
                "\n" +
                "Minuet olarak da bilinen Napolyon kedisi hakkında ilk söyleyeceğimiz şey onun fazlasıyla nazik, sevecen ve insan odaklı oluşudur. Evet, narin bir kedi olan Napolyon yeterince naziktir ve insan dostlarıyla şahane uyumuyla bilinmektedir. Bu özelliğini hem Munchkin hem de İran kedisinden aldığı net olarak ortadadır. İnsan dostlarıyla yakın bağlar kurabilen Napolyon bu bakımdan insan odaklı bir kedi ırkıdır. İlk başka kendisiyle en çok ilgilenen kişi olmak üzere evin diğer üyeleriyle yakın bağlar kurabilme gayreti içerisindedir. Ailesiyle vakit geçirmekten, onlarla oyunlar oynayıp yanlarında olmaktan asla geri durmaz. Gördüğü ilgi ve sevgi karşısında aile üyelerine cömertçe kendi sevgisini vermeye hazırdır." +
                "\n Bakım : \n" +
                "Her kedi gibi Napolyon kedisinin de genel sağlığı ve sağlıklı gelişimi için yüksek kaliteli bir diyetle beslenmesi gereklidir. Kediler etoburdurlar ve ana besin kaynaklarını hayvansal gıdalar oluşturur. Ana bileşen olarak da et ve yüksek protein içeriği olan hayvansal gıda parçacıklarından hazırlanmış ticari mamalar diyeti için tercih edilebilir. Sığır eti, tavuk eti, balık eti, hindi eti gibi yüksek kaliteli gıdalarla beslenmesi sağlanabilir. Bununla beraber, piyasada yavru ve yetişkin kediler için yüksek kaliteli ticari mamalar satılmaktadır. Hem yaş hem de kuru mama karışımı bir diyet benimsenebilir.\n" +
                "\n" +
                "Napolyon cüce kedi ırkları arasında sayılmaktadır. Her ne kadar kısa bacakları onu hareket etmesine mani olmasa da özellikle ilerleyen yaşlarında aktiviteden düştükçe düzensiz beslenmeyle birlikte obezite sorunuyla karşı karşıya kalabilmektedir. Bu nedenle, yaşlılık evresinde diyetinin ölçülü olması için veteriner hekimden yardım alınabilir. Bunun yanı sıra alınacak hazır mamalarda mutlaka minimum günlük beslenme ölçütüne uyulması kedinin sağlıklı gelişimi için önemlidir."," Karakter : \nKarşınızda, dünya genelindeki tüm kedi ırkları arasında popülaritesi her geçen yıl artmaya devam eden ırklardan biri Highlander. Karakulak ve Chausie ırkları arasında melez bir cins kedi olan Highlander kendine özgü egzotik görünümü ve şahane kişilik özellikleri ve güçlü duruşuyla pek çok kedi severin dikkatini çekmektedir. Highlander nispeten nadir bir cins kedidir. Onu diğer pek çok ırktan ayrı tutan şüphesiz kıvrık kulakları ve kısa kuyruğudur. Evet, Highlander kedisine bakıldığında kulaklarının sanki katlı olduğu görülür. Bununla beraber, tıpkı Japon Bobtail’ın kuyruğu gibi kısa, ponpon kuyruk yapısına sahiptir. Ancak eminiz onu daha özel kılan ve hemen herkesi cezbeden parlak kişilik yapısıdır.\n BAKIMI : \n" +
                "Highlander kedisinin çok spesifik bir beslenmeye ihtiyacı yoktur. Özel gıda gereksinimi olmayan Highlander tipik yavru ve yetişkinler için piyasada satılan hazır mamalardan yiyebilmektedir. Kediler bildiğiniz üzere etobur canlılardır. Diyetlerini hayvansal besinler oluşturmaktadır. Protein değeri yüksek, karbonhidrat değeri düşük hazır mamaların yanı sıra çiğ olmamak kaydıyla az pişmiş sığır eti, ciğer, tavuk eti, balık eti ve hindi eti gibi protein değeri yüksek kaliteli besinler tüketebilir.")

        val animalList = mutableListOf<animalsdata>()

        for (i in isimler.indices) {
            animalList.add(animalsdata(isimler[i], resimler[i], bilgiler[i]))
        }

        return animalList
    }
}
}