#!/usr/bin/env bash

set -e

die () {
    echo >&2 "$@"
    exit 1
}

[[ -z $(git status -s) ]] || die "git status is not clean"

gradle jsBrowserDistribution

rsync -azpv --exclude maven* --exclude bmath --delete-after  build/dist/js/productionExecutable/* jillesvangurpcom@ftp.jillesvangurp.com:/srv/home/jillesvangurpcom/domains/jillesvangurp.com/htdocs/fluent-ai