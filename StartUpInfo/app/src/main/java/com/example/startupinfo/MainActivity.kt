package com.example.startupinfo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.startupinfo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Startup data for the 10 biggest startups in Turkey
        val startups = listOf(
            Startup("Getir", 2015, "Hızlı Teslimat", "Getir, gıda ve market ürünlerini dakikalar içinde teslim eden bir platformdur. Geniş bir hizmet ağı ve kaliteli teslimat sistemi ile kullanıcılara özel kampanyalar sunmaktadır."),
            Startup("Trendyol", 2010, "E-Ticaret", "Trendyol, Türkiye'nin en önde gelen e-ticaret platformudur. Moda, teknoloji, ev ürünleri gibi birçok kategoride geniş ürün yelpazesine sahiptir."),
            Startup("Yemeksepeti", 2001, "Yemek Siparişi", "Yemeksepeti, Türkiye'nin ilk ve en büyük online yemek sipariş platformudur. Kullanıcılarına çeşitli restoranlardan hızlı ve kolay şekilde yemek siparişi verme imkânı sunar."),
            Startup("Hepsiburada", 2000, "E-Ticaret", "Hepsiburada, tüm tür ihtiyaçları karşılayabilecek çok geniş bir ürün yelpazesine sahip olan Türkiye'nin en önde gelen e-ticaret sitelerinden biridir."),
            Startup("Insider", 2012, "Pazarlama Teknolojileri", "Insider, markaların dijital pazarlama kampanyalarını optimize etmelerine yardımcı olan yenilikçi bir yazılım startup'ıdır. Çoklu kanal yönetimi ve kişiselleştirme teknolojileri sunar."),
            Startup("Vistacopy", 2017, "Dijital Çözümler", "Vistacopy, dijital baskı ve yazıcı çözümleri sunan yenilikçi bir şirket olup büyük firmaların baskı işlerini yönetmelerine yardımcı olur."),
            Startup("N11", 2013, "E-Ticaret", "N11, güvenilir bir çevrim içi alışveriş platformu olarak Türkiye genelinde çeşitli ürünler sunar. Kampanyaları ve özel indirimleri ile dikkat çeker."),
            Startup("Gram Games", 2013, "Oyun Geliştirme", "Gram Games, popüler mobil oyunlar geliştiren bir oyun firmasıdır. 1010! ve Merge Dragons gibi başarılı oyunlara sahiptir."),
            Startup("Dream Games", 2017, "Oyun Geliştirme", "Dream Games, mobil oyun sektöründe yenilikçi çözümler sunan bir geliştirici firmadır. Royal Match gibi popüler oyunlarla sektörde öne çıkmıştır."),
            Startup("BiTaksi", 2013, "Ulaşım", "BiTaksi, kullanıcıların taksi çağırmasını kolaylaştıran yenilikçi bir uygulamadır. Anlık konum bilgisi ve online ödeme seçenekleri ile kullanıcı dostu bir deneyim sunar.")
        )

        // Set up RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = StartupAdapter(startups) { startup ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("startup_name", startup.name)
            intent.putExtra("startup_foundedYear", startup.foundedYear)
            intent.putExtra("startup_sector", startup.sector)
            intent.putExtra("startup_description", startup.description)
            startActivity(intent)
        }

    }
}