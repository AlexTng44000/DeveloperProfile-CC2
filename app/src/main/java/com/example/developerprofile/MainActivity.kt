
package com.example.developerprofile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.developerprofile.ui.theme.DeveloperProfileTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.foundation.clickable
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.Card
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn

data class ProjectUi(
    val title: String,
    val description: String,
    val technology: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            DeveloperProfileTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileScreen(
                        name = "Alex TANGUY ",
                        role = "Développeur Android junior",
                        description = "Étudiant en informatique, passionné par le développement mobile.",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileScreen(
    name: String,
    role: String,
    description: String,
    modifier: Modifier = Modifier
) {
    val skills = listOf(
        "Kotlin",
        "Jetpack Compose",
        "Git",
        "Android Studio",
        "Compose UI"
    )

    val projects = listOf(
        ProjectUi(
            title = "Profil développeur",
            description = "Application Android présentant une fiche de profil développeur.",
            technology = "Kotlin, Jetpack Compose"
        ),
        ProjectUi(
            title = "Product Explorer",
            description = "Application Android présentant des produits, leurs caractéristiques et leurs prix.",
            technology = "Kotlin, Material Design 3"
        )
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        item {
            ProfileHeader(
                name = name,
                role = role,
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        item {
            Text(
                text = "Compétences",
                style = MaterialTheme.typography.titleMedium
            )
        }

        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                items(skills) { skill ->
                    SkillCard(skill = skill)
                }
            }
        }

        item {
            Text(
                text = "Mes projets",
                style = MaterialTheme.typography.titleMedium
            )
        }

        items(projects) { project ->
            ProjectCard(project = project)
        }

        item {
            ContactInfo(
                availability = "Disponible pour un nouveau poste"
            )
        }

        item {
            ProfileAction(
                label = "Contacter le développeur",
                onClick = {
                    // Action de contact
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    DeveloperProfileTheme {
        ProfileScreen(
            name = "Alex TANGUY",
            role = "Développeur Android junior",
            description = "Étudiant en informatique, passionné par le développement mobile."
        )
    }
}

@Composable
fun ProfileHeader(
    name: String,
    role: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier.size(80.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.ic_launcher_foreground
                    ),
                    contentDescription = "Avatar de $name",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                )

                Surface(
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.primary
                ) {
                    Text(
                        text = "✓",
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = role,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun SkillCard(
    skill: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            text = skill,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 12.dp
            )
        )
    }
}

@Composable
fun ProjectCard(
    project: ProjectUi,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = project.title,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = project.description,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Technologies : ${project.technology}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
fun ContactInfo(
    availability: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = availability,
        style = MaterialTheme.typography.bodyMedium,
        modifier = modifier.padding(top = 20.dp)
    )
}
@Composable
fun ProfileAction(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .clickable(
                role = Role.Button,
                onClick = onClick
            )
            .semantics {
                contentDescription = label
            },
        color = MaterialTheme.colorScheme.primaryContainer
    ) {
        Text(
            text = label,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SecondProfilePreview() {
    DeveloperProfileTheme {
        ProfileScreen(
            name = "Camille Durand",
            role = "Développeuse Android confirmée",
            description = "Développeuse spécialisée dans la création d'applications Android modernes."
        )
    }
}

