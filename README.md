[![Process Pull Request](https://github.com/jillesvangurp/fluent-ai/actions/workflows/pr_master.yaml/badge.svg)](https://github.com/jillesvangurp/fluent-ai/actions/workflows/pr_master.yaml)

# Fluent AI

Open source editor for [project fluent](https://projectfluent.org/) localization files with AI assisted translations. Save time and money translating your applications into any language you want.

## Getting Started

Open [Fluent AI](https://fluent-ai.jillesvangurp.com/) in your browser or run it locally (see below).

## Features

Briefly, the application uses OpenAI to provide translations for either indididual translation ids in your localiazation files or entire fluent files. This is amazing for quickly adding new languages to your application.

For a more detailed overview of the application, go to the [About](https://fluent-ai.jillesvangurp.com/#page=About) screen in Fluent AI. Also, don't miss out on some of the creative translations done by OpenAI. My favorite is the **en-poet** one.

## Running this yourself

- make sure you have a recent jdk installed
- run `./gradlew jsBrowserDevelopment -t`, that will run a development version of the app. Look at the kotlin-js [documentation](https://kotlinlang.org/docs/js-project-setup.html#run-task) for more things you can do with kotlin-js.

## Why?

Localizing applications is a chore and making that easy saves time and money. We have hundreds of translation strings in multiple languages. Editing these files manually is a PITA.

Why a webapp? Because it's easy. I might level it up to something else at some point. But this is a hobby project. If you wish to pay me to do this, I'm open to suggestions.

Why kotlin-js? It's what I use a lot and like. And Kotlin is a good language for this stuff.
