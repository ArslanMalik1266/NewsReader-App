package com.example.newsreaderpractice.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsreaderpractice.R
import com.example.newsreaderpractice.ViewModel.NewsViewModel
import com.example.newsreaderpractice.adaptor.NewsAdapter
import com.example.newsreaderpractice.adaptor.NewsItem



class HomeFragment : Fragment() {
    private lateinit var adaptor: NewsAdapter
    private lateinit var recyclerView: RecyclerView
    private val newsViewModel: NewsViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        newsViewModel.initializeSharedPreferences(requireContext())

        recyclerView = view.findViewById(R.id.recyclerViewNews)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        getAllItems()

        return view
    }

    private fun getAllItems() {
        val dummyNews = listOf(
            NewsItem(
                imageUrl = "https://picsum.photos/200/300",
                title = "AI Revolutionizes Healthcare",
                source = "Health Today",
                date = "2024-03-20T10:00:00Z",
                isBookmarked = false,
                description = "Artificial Intelligence is transforming healthcare by enabling faster diagnosis, personalized treatment plans, and predictive analytics. AI-powered tools are helping doctors detect diseases like cancer at earlier stages, improving patient outcomes. Hospitals are also using AI to streamline administrative tasks, reducing costs and wait times. With advancements in machine learning, AI is expected to revolutionize drug discovery and clinical trials. However, ethical concerns around data privacy and bias remain challenges. The future of healthcare lies in the seamless integration of AI with human expertise.Artificial Intelligence is transforming healthcare by enabling faster diagnosis, personalized treatment plans, and predictive analytics. AI-powered tools are helping doctors detect diseases like cancer at earlier stages, improving patient outcomes. Hospitals are also using AI to streamline administrative tasks, reducing costs and wait times. With advancements in machine learning, AI is expected to revolutionize drug discovery and clinical trials. However, ethical concerns around data privacy and bias remain challenges. The future of healthcare lies in the seamless integration of AI with human expertise.Artificial Intelligence is transforming healthcare by enabling faster diagnosis, personalized treatment plans, and predictive analytics. AI-powered tools are helping doctors detect diseases like cancer at earlier stages, improving patient outcomes. Hospitals are also using AI to streamline administrative tasks, reducing costs and wait times. With advancements in machine learning, AI is expected to revolutionize drug discovery and clinical trials. However, ethical concerns around data privacy and bias remain challenges. The future of healthcare lies in the seamless integration of AI with human expertise.Artificial Intelligence is transforming healthcare by enabling faster diagnosis, personalized treatment plans, and predictive analytics. AI-powered tools are helping doctors detect diseases like cancer at earlier stages, improving patient outcomes. Hospitals are also using AI to streamline administrative tasks, reducing costs and wait times. With advancements in machine learning, AI is expected to revolutionize drug discovery and clinical trials. However, ethical concerns around data privacy and bias remain challenges. The future of healthcare lies in the seamless integration of AI with human expertise."
            ),
            NewsItem(
                imageUrl = "https://picsum.photos/200/301",
                title = "SpaceX Launches New Satellite",
                source = "Space News",
                date = "2024-03-20T09:30:00Z",
                isBookmarked = false,
                description = "SpaceX has successfully launched its latest satellite, designed to enhance global internet connectivity. The satellite is part of the Starlink project, aiming to provide high-speed internet to remote areas. This launch marks another milestone in SpaceX's mission to bridge the digital divide. The satellite will orbit the Earth at a low altitude, ensuring faster data transmission. SpaceX plans to deploy thousands more satellites in the coming years. Critics, however, raise concerns about space debris and the impact on astronomical observations. Despite challenges, SpaceX continues to push the boundaries of space technology."
            ),
            NewsItem(
                imageUrl = "https://picsum.photos/200/302",
                title = "Global Warming: A Call to Action",
                source = "Eco Watch",
                date = "2024-03-20T08:45:00Z",
                isBookmarked = false,
                description = "Scientists warn that global warming has reached a critical point, with rising temperatures causing irreversible damage to ecosystems. Melting ice caps, rising sea levels, and extreme weather events are becoming more frequent. Governments and organizations are urged to take immediate action to reduce carbon emissions. Renewable energy sources like solar and wind power are key to mitigating climate change. Individuals can also contribute by adopting sustainable practices. The time to act is now, as the consequences of inaction will be catastrophic for future generations."
            ),
            NewsItem(
                imageUrl = "https://picsum.photos/200/303",
                title = "New Smartphone Breaks Speed Records",
                source = "Tech Insider",
                date = "2024-03-19T15:20:00Z",
                isBookmarked = false,
                description = "The latest smartphone from a leading tech company has set new benchmarks for speed and performance. Powered by a cutting-edge processor, the device offers lightning-fast app loading and multitasking capabilities. Its advanced camera system delivers professional-grade photography, even in low-light conditions. The phone also features a long-lasting battery and 5G connectivity. Early reviews praise its sleek design and user-friendly interface. With its innovative features, this smartphone is set to dominate the market and redefine mobile technology."
            ),
            NewsItem(
                imageUrl = "https://picsum.photos/200/304",
                title = "World's Largest Solar Farm Opens",
                source = "Green Energy News",
                date = "2024-03-19T14:10:00Z",
                isBookmarked = false,
                description = "The world's largest solar farm has officially opened, marking a significant step toward renewable energy adoption. Located in a remote desert region, the farm spans thousands of acres and generates enough electricity to power millions of homes. The project has created thousands of jobs and boosted the local economy. It also reduces reliance on fossil fuels, cutting carbon emissions significantly. Experts believe this solar farm sets a precedent for future renewable energy projects worldwide. The success of this initiative highlights the potential of solar energy to combat climate change."
            ),
            NewsItem(
                imageUrl = "https://picsum.photos/200/305",
                title = "Cryptocurrency Market Hits New High",
                source = "Crypto Daily",
                date = "2024-03-19T12:50:00Z",
                isBookmarked = false,
                description = "The cryptocurrency market has reached a new all-time high, driven by increased adoption and institutional investment. Bitcoin, Ethereum, and other major cryptocurrencies have seen significant price surges. Analysts attribute this growth to growing confidence in blockchain technology and its applications. However, the market remains highly volatile, with risks of sudden price drops. Governments worldwide are working on regulations to ensure investor protection. Despite challenges, cryptocurrencies continue to gain traction as a viable alternative to traditional financial systems."
            ),
            NewsItem(
                imageUrl = "https://picsum.photos/200/306",
                title = "New Cancer Treatment Shows Promise",
                source = "Medical Breakthroughs",
                date = "2024-03-18T11:30:00Z",
                isBookmarked = false,
                description = "A groundbreaking cancer treatment has shown remarkable results in clinical trials. The therapy uses genetically modified immune cells to target and destroy cancer cells. Patients who underwent the treatment experienced significant tumor reduction with minimal side effects. Researchers believe this could revolutionize cancer care, offering hope to millions of patients worldwide. The treatment is currently being tested on various types of cancer, with promising outcomes. While further studies are needed, this breakthrough represents a major step forward in the fight against cancer."
            ),
            NewsItem(
                imageUrl = "https://picsum.photos/200/307",
                title = "Tesla Unveils New Electric Truck",
                source = "Auto News",
                date = "2024-03-18T10:15:00Z",
                isBookmarked = false,
                description = "Tesla has unveiled its latest electric truck, designed to revolutionize the transportation industry. The truck boasts an impressive range of over 500 miles on a single charge, making it ideal for long-haul journeys. Its advanced autopilot system enhances safety and reduces driver fatigue. The vehicle also features a sleek, aerodynamic design that improves efficiency. Tesla aims to reduce the carbon footprint of the logistics sector with this innovation. Early reviews praise the truck's performance and sustainability, signaling a bright future for electric commercial vehicles."
            ),
            NewsItem(
                imageUrl = "https://picsum.photos/200/308",
                title = "World Cup 2024: Teams Announced",
                source = "Sports Today",
                date = "2024-03-17T09:00:00Z",
                isBookmarked = false,
                description = "The official list of teams for the 2024 World Cup has been announced, sparking excitement among football fans worldwide. Defending champions are set to face tough competition from emerging teams. The tournament will be held in multiple cities, showcasing state-of-the-art stadiums and infrastructure. Fans can expect thrilling matches and unforgettable moments as the world's best players compete for glory. The event is also expected to boost tourism and local economies. With preparations in full swing, the 2024 World Cup promises to be a celebration of sportsmanship and unity."
            ),
            NewsItem(
                imageUrl = "https://picsum.photos/200/309",
                title = "New AI Tool Detects Fake News",
                source = "Tech Innovations",
                date = "2024-03-17T08:20:00Z",
                isBookmarked = false,
                description = "A new AI-powered tool has been developed to detect and combat fake news. The tool analyzes text, images, and videos to identify misleading content with high accuracy. It uses advanced algorithms to cross-check information against reliable sources. Social media platforms are already integrating this tool to curb the spread of misinformation. Experts believe it will play a crucial role in promoting digital literacy and trust. However, challenges remain in ensuring the tool's fairness and avoiding censorship. This innovation represents a significant step toward a more informed and responsible digital society."
            ),
            NewsItem(
                imageUrl = "https://picsum.photos/200/310",
                title = "Breakthrough in Quantum Computing",
                source = "Tech World",
                date = "2024-03-16T14:30:00Z",
                isBookmarked = false,
                description = "Scientists have achieved a major breakthrough in quantum computing, developing a new quantum processor capable of solving complex problems in seconds. This advancement is expected to revolutionize fields like cryptography, drug discovery, and artificial intelligence. However, experts warn about potential risks to data security as quantum computers could render current encryption methods obsolete."
            ),
            NewsItem(
                imageUrl = "https://picsum.photos/200/311",
                title = "Electric Vehicles Dominate Auto Show",
                source = "Auto Trends",
                date = "2024-03-15T16:45:00Z",
                isBookmarked = false,
                description = "This year's international auto show highlights the dominance of electric vehicles (EVs) in the automotive industry. Major automakers unveiled their latest EV models, featuring extended ranges, faster charging, and advanced driver-assistance systems. Analysts predict EV sales will surpass traditional vehicles by 2030 as sustainability becomes a priority."
            ),
            NewsItem(
                imageUrl = "https://picsum.photos/200/312",
                title = "New Telescope Discovers Habitable Planet",
                source = "Space Explorer",
                date = "2024-03-14T13:20:00Z",
                isBookmarked = false,
                description = "Astronomers using a next-generation telescope have discovered a potentially habitable exoplanet located 40 light-years away. The planet, named Kepler-X1, has Earth-like conditions and lies within its star's habitable zone. Scientists are excited about its potential to host life, sparking renewed interest in space exploration."
            ),
            NewsItem(
                imageUrl = "https://picsum.photos/200/313",
                title = "AI Creates Stunning Artwork",
                source = "Artistry Today",
                date = "2024-03-13T11:10:00Z",
                isBookmarked = false,
                description = "A new AI tool is making waves in the art world by creating breathtaking digital paintings and sculptures. The AI uses machine learning to mimic the styles of famous artists while introducing unique elements. While some hail it as a revolutionary tool, others question its impact on traditional artists."
            ),
            NewsItem(
                imageUrl = "https://picsum.photos/200/314",
                title = "World's Tallest Building Completed",
                source = "Global Architecture",
                date = "2024-03-12T10:00:00Z",
                isBookmarked = false,
                description = "The world's tallest building, reaching a height of 1,500 meters, has been completed in a bustling metropolis. The skyscraper features state-of-the-art technology, luxury residences, and a panoramic observation deck. It symbolizes human ingenuity and is expected to become a global tourist attraction."
            ),
            NewsItem(
                imageUrl = "https://picsum.photos/200/315",
                title = "Breakthrough in Alzheimer's Research",
                source = "Medical News",
                date = "2024-03-11T09:50:00Z",
                isBookmarked = false,
                description = "Researchers have made significant progress in understanding Alzheimer's disease, identifying a new biomarker that could lead to early detection and targeted treatments. This discovery brings hope to millions of patients and their families, marking a crucial step toward finding a cure."
            ),
            NewsItem(
                imageUrl = "https://picsum.photos/200/316",
                title = "Global Economic Summit Kicks Off",
                source = "World News",
                date = "2024-03-10T08:30:00Z",
                isBookmarked = false,
                description = "Leaders from around the world have gathered for the annual Global Economic Summit to discuss pressing issues like trade policies, climate change, and economic recovery post-pandemic. Experts emphasize the importance of international cooperation to address global challenges effectively."
            ),
            NewsItem(
                imageUrl = "https://picsum.photos/200/317",
                title = "Famous Landmark Restored to Glory",
                source = "Cultural Heritage",
                date = "2024-03-09T17:15:00Z",
                isBookmarked = false,
                description = "After years of restoration work, a world-famous historical landmark has reopened to the public. The project preserved its architectural integrity while adding modern safety features. Visitors are thrilled to witness the blend of history and innovation in this iconic site."
            ),
            NewsItem(
                imageUrl = "https://picsum.photos/200/318",
                title = "Revolutionary Battery Technology Unveiled",
                source = "Tech Daily",
                date = "2024-03-08T14:40:00Z",
                isBookmarked = false,
                description = "A breakthrough in battery technology promises to transform energy storage. The new battery is safer, lasts longer, and charges faster than current options. Its developers envision applications in electric vehicles, renewable energy systems, and portable electronics, making a significant impact on the energy sector."
            ),
            NewsItem(
                imageUrl = "https://picsum.photos/200/319",
                title = "Major Breakthrough in Fusion Energy",
                source = "Energy Insights",
                date = "2024-03-07T13:25:00Z",
                isBookmarked = false,
                description = "Scientists have achieved a major milestone in fusion energy, successfully sustaining a reaction for longer than ever before. This progress brings the dream of limitless, clean energy closer to reality. Experts are optimistic about the potential for fusion power to replace fossil fuels."
            ),
            NewsItem(
                imageUrl = "https://picsum.photos/200/320",
                title = "Olympic Games 2024 Preparations Underway",
                source = "Sports Arena",
                date = "2024-03-06T15:30:00Z",
                isBookmarked = false,
                description = "Preparations for the 2024 Olympic Games are in full swing, with the host city unveiling state-of-the-art facilities. Organizers promise a sustainable event, with eco-friendly venues and initiatives to reduce the environmental impact of the games. Fans worldwide eagerly anticipate the grand event."
            ),
            NewsItem(
                imageUrl = "https://picsum.photos/200/321",
                title = "New Discovery in Deep-Sea Exploration",
                source = "Ocean News",
                date = "2024-03-05T11:00:00Z",
                isBookmarked = false,
                description = "Marine scientists have discovered a new species of bioluminescent creatures in the deep sea. The findings shed light on the unique ecosystems that exist in the ocean's darkest depths. Researchers hope this discovery will inspire efforts to protect these fragile habitats."
            ),
            NewsItem(
                imageUrl = "https://picsum.photos/200/322",
                title = "Breakthrough in Solar Panel Efficiency",
                source = "Energy Innovations",
                date = "2024-03-04T09:15:00Z",
                isBookmarked = false,
                description = "Engineers have developed a new solar panel technology that significantly improves energy conversion efficiency. The panels are more durable and cost-effective, making renewable energy accessible to a broader audience. This innovation could accelerate the transition to a green energy future."
            ),
            NewsItem(
                imageUrl = "https://picsum.photos/200/323",
                title = "New AI Algorithm Solves Complex Problems",
                source = "AI Today",
                date = "2024-03-03T12:50:00Z",
                isBookmarked = false,
                description = "A newly developed AI algorithm has demonstrated the ability to solve complex mathematical problems faster than ever before. This breakthrough is expected to have significant applications in fields like cryptography, finance, and scientific research, revolutionizing problem-solving capabilities."
            ),
            NewsItem(
                imageUrl = "https://picsum.photos/200/324",
                title = "Major Advancements in Robotics",
                source = "Tech Frontier",
                date = "2024-03-02T10:40:00Z",
                isBookmarked = false,
                description = "A new generation of robots with advanced AI capabilities has been unveiled, capable of performing tasks with unprecedented precision and efficiency. These robots are expected to revolutionize industries like manufacturing, healthcare, and logistics, ushering in a new era of automation."
            ),
            NewsItem(
                imageUrl = "https://picsum.photos/200/325",
                title = "Global Climate Agreement Reached",
                source = "World Environment",
                date = "2024-03-01T16:20:00Z",
                isBookmarked = false,
                description = "World leaders have signed a historic climate agreement committing to aggressive carbon reduction targets. The pact aims to limit global warming to 1.5°C and includes initiatives to promote renewable energy, reforestation, and sustainable practices worldwide."
            )
        )
        val updatedNews = newsViewModel.loadSavedStates(dummyNews)
        newsViewModel.setNewsList(updatedNews)

        adaptor = NewsAdapter(
            onItemClick = { newsItem ->
                val intent = Intent(requireContext(), newsDetailScreen::class.java)
                intent.putExtra("newsItem", newsItem)
                startActivity(intent)
            },
            onBookmarkToggle = { newsItem ->
                newsViewModel.toggleBookmark(newsItem)
            }
        )
        recyclerView.adapter = adaptor
        newsViewModel.newsList.observe(viewLifecycleOwner) { news ->
            adaptor.submitList(news)
        }
    }


}