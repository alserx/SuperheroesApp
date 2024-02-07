package es.alvaro.serna.superheroesapp.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import es.alvaro.serna.superheroesapp.R
import es.alvaro.serna.superheroesapp.model.Hero
import es.alvaro.serna.superheroesapp.model.HeroesRepository.heroes
import es.alvaro.serna.superheroesapp.ui.theme.SuperheroesTheme

class HeroesScreen {

    @Composable
    fun SuperheroesList(
        modifier: Modifier = Modifier,
        contentPadding: PaddingValues = PaddingValues()
    ) {
        LazyColumn(modifier = modifier, contentPadding = contentPadding) {
            items(heroes) { hero ->
                SuperheroCard(
                    hero = hero,
                    modifier = Modifier
                        .padding(
                            dimensionResource(R.dimen.padding_medium)
                        )
                )
            }
        }
    }

    @Composable
    private fun SuperheroCard(hero: Hero, modifier: Modifier = Modifier) {
        Card(
            modifier = modifier,
            elevation = CardDefaults.cardElevation(dimensionResource(R.dimen.card_elevation)),
            shape = MaterialTheme.shapes.medium
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = dimensionResource(R.dimen.padding_big),
                        vertical = dimensionResource(R.dimen.padding_big)
                    )
                    .size(dimensionResource(R.dimen.image_size))
            ) {
                HeroInformation(hero = hero, modifier = Modifier.weight(0.75f))
                Spacer(
                    modifier = Modifier
                        .padding(horizontal = dimensionResource(R.dimen.padding_big))
                )
                HeroIcon(hero = hero, modifier = Modifier.weight(1.0f))
            }
        }
    }

    @Composable
    private fun HeroInformation(
        modifier: Modifier = Modifier,
        hero: Hero
    ) {
        Column(modifier = modifier) {
            Text(
                text = stringResource(hero.nameRes),
                style = MaterialTheme.typography.displaySmall
            )
            Text(
                text = stringResource(hero.descriptionRes),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }

    @Composable
    private fun HeroIcon(
        modifier: Modifier = Modifier,
        hero: Hero
    ) {
        Box {
            Image(
                modifier = modifier
                    .size(dimensionResource(R.dimen.image_size))
                    .padding(dimensionResource(R.dimen.padding_small))
                    .clip(MaterialTheme.shapes.small),
                painter = painterResource(hero.imageRes),
                contentScale = ContentScale.Crop,
                contentDescription = stringResource(hero.nameRes),
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun HeroesListPreview() {
        SuperheroesTheme {
            SuperheroesList()
        }
    }
}

