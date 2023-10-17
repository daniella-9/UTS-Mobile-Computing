package com.example.daftarmatakuliah

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.daftarmatakuliah.ui.theme.DaftarMataKuliahTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaftarMataKuliahTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val namamatkul = arrayOf(
                        "Mobile Computing",
                        "Dasar-Dasar Pemrograman",
                        "Animasi Komputer",
                        "Pendidikan Pancasila",
                        "Perancangan dan Pemrograman Web",
                        "Teknologi Informasi",
                        "Kewirausahaan",
                        "Komputer dan Masyarakat",
                        "Teori Bahasa dan Automata",
                        "Logika dan Penalaran Ilmiah",
                        "Data mining"
                    )

                    val sks = arrayOf(
                        "3 SKS",
                        "3 SKS",
                        "3 SKS",
                        "2 SKS",
                        "3 SKS",
                        "3 SKS",
                        "2 SKS",
                        "2 SKS",
                        "2 SKS",
                        "3 SKS"
                    )

                    val ikon = arrayOf(
                        R.drawable.mobcom,
                        R.drawable.ddp,
                        R.drawable.anikom,
                        R.drawable.pendidikanpancasila,
                        R.drawable.ppw,
                        R.drawable.ti,
                        R.drawable.kwh,
                        R.drawable.kommas,
                        R.drawable.tba,
                        R.drawable.lpi,
                        R.drawable.datamining
                    )
                    DaftarMatkulApp(namamatkul, sks, ikon)
                }
            }
        }
    }
}

@Composable
fun DaftarMatkulApp(
    namamatkul: Array<String>,
    sks: Array<String>,
    ikon: Array<Int>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(200.dp),
        contentPadding = PaddingValues(16.dp)
    )
    { val itemCount = ikon.size
        items(itemCount) { item ->
            ColoumItem(
                itemIndex = item,
                nama = namamatkul,
                sks = sks,
                pict = ikon,
                modifier
            )
        }
    }
}

@Composable fun ColoumItem(
    itemIndex: Int,
    nama: Array<String>,
    sks: Array<String>,
    pict: Array<Int>,
    modifier: Modifier
) {
    Card(
        modifier .padding(10.dp) .wrapContentSize(align = Alignment.TopCenter),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Image(
                painter = painterResource(id = pict[itemIndex]),
                contentDescription = nama[itemIndex],
                modifier.size(140.dp)
            )
            Column(modifier.padding(12.dp)) {
                Text(text = nama[itemIndex],
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp)
                Text(text = sks[itemIndex],
                    fontSize = 18.sp)
            }
        }
    }

    }