[![Process Pull Request](https://github.com/jillesvangurp/fluent-ai/actions/workflows/pr_master.yaml/badge.svg)](https://github.com/jillesvangurp/fluent-ai/actions/workflows/pr_master.yaml)

# Fluent AI

Editor for project fluent localization files.

## Status

Note. this is very much a work in progress. I'll update the readme when things get usable.

## High level plan

- web app that allows you to edit fluent translations in the form of multiple flt files (one for each language)
- easily identify missing translation strings for languages
- edit translation strings
- automated translations using openai
- export ftl files back for usage

## Why

Localizing applications is a chore and making that easy saves time and money. We have hundreds of translation strings in multiple languages. Editing these files manually is a PITA.

Why a webapp? Because it's easy. I might level it up to something else at some point. But this is a hobby project. If you wish to pay me to do this, I'm open to suggestinos.

Why kotlin-js? It's what I use a lot and like. And Kotlin is a good language for this stuff.