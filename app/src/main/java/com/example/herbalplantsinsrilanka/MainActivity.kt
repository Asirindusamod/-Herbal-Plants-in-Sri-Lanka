package com.example.herbalplantsinsrilanka

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.herbalplantsinsrilanka.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), PlantAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var plantList: MutableList<PlantItem>
    private lateinit var adapter: PlantAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize plantList with herbal plants data
        plantList = mutableListOf(
            PlantItem("NAWAHANDI", "Rhipsalis baccifera", "nawahandi, also known as \"Brahmi,\" The pencil tree is a shrub or small tree with pencil-thick, green, smooth, succulent branches that reaches heights of up to 7 metres (23 ft). It has a cylindrical and fleshy stem with fragile succulent twigs that are 7 millimetres (0.28 in) thick, often produced in whorls, longitudinally, finely striated. The oval leaves are 1 to 2.5 centimetres (0.39 to 0.98 in) long and about 3 to 4 millimetres (0.12 to 0.16 in) wide; they usually fall off early. It contains a milky, toxic and corrosive sap. The yellow flowers are at the ends of the branches.", "https://www.google.com/imgres?q=nawahandi%20wikipedia&imgurl=https%3A%2F%2Fwww.asia-medicinalplants.info%2Fwp-content%2Fuploads%2F2016%2F09%2FEuphorbia-tirucalli-L.-1.jpg&imgrefurl=https%3A%2F%2Fwww.asia-medicinalplants.info%2Feuphorbia-tirucalli-l%2F&docid=1Bh0g1fAu3VNLM&tbnid=fgk04pzPzqQZgM&vet=12ahUKEwjn6Oq6rNGFAxXWV2wGHdHCBqYQM3oECGMQAA..i&w=1256&h=940&hcb=2&ved=2ahUKEwjn6Oq6rNGFAxXWV2wGHdHCBqYQM3oECGMQAA"),
            PlantItem("RANAWARA", "Senna auriculata", "Ranawara, or \"Avaram,\" is a shrub native to Sri Lanka with significant medicinal properties. It is commonly used in Ayurvedic medicine to manage diabetes by regulating blood sugar levels. Ranawara is also beneficial for skin health, helping to treat conditions like acne and itching. Additionally, it has diuretic properties and is used to cleanse the urinary system. This herb is brewed into a tea and consumed for its health benefits.", "https://upload.wikimedia.org/wikipedia/commons/archive/a/a6/20180729173638%21Ranawara_or_Avaram-_Senna_auriculata_at_Sindhrot_near_Vadodara%2C_Gujrat_Pix_044.jpg"),
            PlantItem("AKKAPANA", "Salacia reticulata", "Cathedral Bells is a species in Crassulaceae family, referred in various names in different countries. It is a succulent plant naturalized from Madagascar where it's origin. The plant Commonly found in home gardens in Sri Lanka and some times seen as a weed in shady places. In Sri Lanka, it is rarely use in Ayurveda as a remedy and is poisonous to the humans and animals. New plant can germinate by leaf without the soil", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fslflora.blogspot.com%2F2015%2F07%2Fcathedral-bells-akkapana.html&psig=AOvVaw0YGFsckcXhNTNT6wIRo4Da&ust=1713721840532000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCKDMw8Ct0YUDFQAAAAAdAAAAABAE"),
            PlantItem("IRAMUSU", "Hemidesmus indicus", "Iramusu, also called \"Indian Sarsaparilla,\" is known for its blood-purifying properties in Ayurvedic medicine. It is used to detoxify the body, improve skin health, and treat various skin disorders like acne and eczema. Iramusu is also used to support digestive function and relieve gastric disturbances. Additionally, it is believed to have anti-inflammatory effects and is used in formulations for arthritis and rheumatic conditions.", "https://upload.wikimedia.org/wikipedia/commons/d/d2/Hemidesmus_scandens.jpg"),
            PlantItem("WENIWAL", "Coscinium fenestratum", "Weniwel, or \"Tree Turmeric,\" is a medicinal plant native to Sri Lanka. It is valued for its antimicrobial and anti-inflammatory properties. Weniwel is used to treat infections, particularly skin infections, and promote wound healing. In traditional medicine, it is also used to support liver health and detoxification. Weniwel is prepared as a decoction or applied topically for skin-related issues.", "https://upload.wikimedia.org/wikipedia/commons/7/73/Coscinium_fenestratum.jpg"),
            PlantItem("KOMARIKA", "Aloe vera", "Aloe vera is a herb with succulent leaves that are arranged in a rosette. The leaves are grey to green and sometimes have white spots on their surfaces. They have sharp, pinkish spines along their edges and are the source of the colourless gel found in many commercial and medicinal products. Aloe vera has yellow, tube-like flowers that cluster on a stem..", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.goodhousekeeping.com%2Fhome%2Fgardening%2Fg19682442%2Faloe-plant-care%2F&psig=AOvVaw0xts_uTfAAgvYUk6CWEdV8&ust=1713722054149000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCODz76Ou0YUDFQAAAAAdAAAAABAE"),
            PlantItem("KOTHTHAMALLI", "Coriandrum sativum", "Koththamalli, commonly known as coriander or cilantro, is a versatile herb used in Sri Lankan cuisine and traditional medicine. It is rich in antioxidants, vitamins, and minerals, making it beneficial for overall health. In culinary applications, koththamalli is used fresh as a garnish or in cooking to add flavor to dishes. It has digestive properties and is believed to alleviate digestive issues like bloating and indigestion. Additionally, koththamalli is used in traditional medicine for its anti-inflammatory and antibacterial properties, aiding in the treatment of skin conditions and promoting overall wellness.", "https://upload.wikimedia.org/wikipedia/commons/1/13/Coriandrum_sativum_-_K%C3%B6hler%E2%80%93s_Medizinal-Pflanzen-193.jpg"),
        )

        // Initialize RecyclerView and set up adapter
        adapter = PlantAdapter(this, plantList, this)
        binding.recyclerViewPlants.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewPlants.adapter = adapter

        // Set click listener for Add Plant button
        binding.btnAddPlant.setOnClickListener {
            val intent = Intent(this, AddPlantActivity::class.java)
            startActivityForResult(intent, ADD_PLANT_REQUEST)
        }
    }

    override fun onItemClick(plantItem: PlantItem) {
        // Handle item click (e.g., show detailed view)
        val intent = Intent(this, DetailedItemActivity::class.java).apply {
            putExtra("plant_item", plantItem)
        }
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ADD_PLANT_REQUEST && resultCode == RESULT_OK) {
            // Retrieve new plant item from AddPlantActivity
            val newPlantItem = data?.getParcelableExtra<PlantItem>("new_plant_item")

            if (newPlantItem != null) {
                // Add new plant item to the list
                plantList.add(newPlantItem)
                adapter.notifyDataSetChanged()
            }
        }
    }

    companion object {
        private const val ADD_PLANT_REQUEST = 1
    }
}
