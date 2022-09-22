# NetworkCaseStudy

* main/java/DriverSetup chrome driver kurulumunun yapıldığı sınıftır chrome driver için bonigarcia kütüphanesini kullandım
* main/java/pages class larında sayfalarda yapılan işlemler vvardım
* main/java/resources registrationData.csv dosyası kullanıcı girişi için eposta ve şifre verilerini içerir giriş için buradaki veriler kullanılır
* test/java/TestPage class ında testler yer alır

## Test Case

* Network sayfasına girilir

* Network url nin geldiği kontrol edilir

* Arama sekmesinde denim yazdırılır ve arama yaptırılır

* Ürün listeme sayfasında daha fazla göster butonuna kadar scroll yapılır

* 2.sayfaya geçildiği kontrol edilir(url değişiyor)

* Ürün listeme sayfasında İndirimli ilk ürüne hover edilerek rastgele beden seçimi yapılır

* Sağ alt köşede açılan Sepete git butonu seçilir.

* Ürüne ait beden ve fiyat bilgisinin sepette doğru geldiği kontrol edilir

* Sepete eklen ürünün eski fiyatının indirimli fiyatından büyük olduğu kontrol ettirilir

* Devam et butonuna tıklanır.

* Kullanıcı bilgileri csv formatından çekilerek doldurulur (E-posta - şifre csv uzantılı dosyadan okunması
gerekmektedir.)

* Giriş yap butonunun geldiği kontrol edilir

* Network logosuna tıklanır.

* Anasayfa üzerinde çantalogosununa tıklanarak Sepetim ekranın sağ tarafında açılır.

* Ürün sepetten çıkarılarak sepetin boş olduğu kontrol edilir
