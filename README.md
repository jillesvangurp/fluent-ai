[![Process Pull Request](https://github.com/jillesvangurp/fluent-ai/actions/workflows/pr_master.yaml/badge.svg)](https://github.com/jillesvangurp/fluent-ai/actions/workflows/pr_master.yaml)

# Fluent AI

Open source editor for [project fluent](https://projectfluent.org/) localization files.

## Getting Started

Open [Fluent AI](https://fluent-ai.jillesvangurp.com/)

## Features

- drag and drop your ftl files to the browser to load them
- browse through and see all the translations for each id side by side
- edit translations in the browser
- get AI assisted translations

## Running this yourself

- make sure you have a recent jdk installed
- run `./gradlew jsBrowserDevelopment -t`, that will run a development version of the app. Look at the kotlin-js [documentation](https://kotlinlang.org/docs/js-project-setup.html#run-task) for more things you can do.

If this gets a bit of traction, I might look into ways to monetize this. For now it's all free OSS.

## Why?

Localizing applications is a chore and making that easy saves time and money. We have hundreds of translation strings in multiple languages. Editing these files manually is a PITA.

Why a webapp? Because it's easy. I might level it up to something else at some point. But this is a hobby project. If you wish to pay me to do this, I'm open to suggestions.

Why kotlin-js? It's what I use a lot and like. And Kotlin is a good language for this stuff.