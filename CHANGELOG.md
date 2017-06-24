# Change Log
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/) 
and this project adheres to [Semantic Versioning](http://semver.org/).

## Unreleased
### Added
- advanced supported rxjs version to 5.4.1 
- skipLast operator (rxjs 5.4.0)
- maxWindowSize parameter in windowTime operator
- methods definitions generator for automatically test methods availability (trying to make migration to new rxjs versions easier)

## [1.1.4] - 2017-03-23
### Added
- fixed jsinterop definition for Subscription
- renamed AnonymousSubscription to TearDownSubscription to make it more meaningful

## [1.1.3] - 2017-01-30
### Added
- fixed generic definition for key comparator
- fixed "subscribe" signature

## [1.1.2] - 2017-01-30
### Added
- added forgotten "capture" for fromEvent

## [1.1.1] - 2017-01-30
### Added
- pluck operator
- flatMap and flatMapTo aliases
- fixed generics

## [1.1.0] - 2017-01-12
### Added
- Observable.fromEvent
- ObservableEx.fromMouseEvent
- ObservableEx.fromKeyboardEvent
- JsInterops for mouse and keyboard events

## [1.0.0] - 2017-01-07
### Added
- Initial release with basic functionality (almost all operators for Observable)
