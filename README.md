# FeatureLib

A collection of multi-platform implementations of common tasks for developing Minecraft mods. 
Designed to be modular so you can jar-in-jar only the parts you need. 
A priority is placed on never manually to writing serialization code for nbt or byte buffers. 

Features: Config, Packets, Saved Data
Supported Mod Loaders: Forge, Fabric, Quilt
Supported Versions: 1.19, 1.18, 1.16

## Config

- [X] support configs on both client and server sides
- [ ] sync server side configs to the client
- [X] define default values in code
- [X] generate default config file with comments
- [X] json format for good support of nested map data structures
- [X] server checks global folder so modpacks can ship defaults
- [X] shadow so no external dependencies
- [ ] cross platform: forge, fabric, quilt
- [X] lightweight: no extra bloat increasing your jar size
- [X] no boilerplate: just write a data class
- [ ] automatic integration with config screen api
- [ ] generate english lang file for screens based on comment annotations
- [ ] min and max values for numbers with annotations
- [ ] validator annotation 
- [ ] watch file for changes and reload config
- [ ] reload configs with reload command
- [ ] comment translations

TODO: chart with comparison to other config libraries
- Forge Config & Fuzss/forgeconfigapiport-fabric (verbose)
- Draylar/omega-config (fabric only)
- wisp-forest/owo-lib (fabric only, bloat)
- shedaniel/cloth-config (not synced)
- Minenash/TinyConfig (fabric only, not synced)
- ZsoltMolnarrr/TinyConfig (fabric only, not synced)
- isXander/YetAnotherConfigLib (client only, fabric only)
- LambdAurora/SpruceUI (verbose, fabric only, not synced)
- TeamMidnightDust/MidnightLib (bloat, not synced)

## Packets

Replaces `SimpleChannel` on Forge or `ClientPlayNetworking` and `ServerPlayNetworking` on Fabric.

- [ ] automatically serialize your data class (to json to bytebuffer)
- [ ] cross platform: forge, fabric, quilt
- [ ] send options: client -> server, server -> client, server -> all clients
- [ ] handshake system to know that server and client are on the same version

## Saved Data

Replaces `WorldSavedData` and capabilities on Forge or cardinal components on Fabric.

Data for all players is stored in a json file mapping uuids to data objects. 
World data is just a file with a json object (perhaps multiple files if stored separate per dimension).

- [ ] store data in a json file instead of nbt for easy editing
- [ ] automatically serialize your data class
- [ ] sync data to clients
- [ ] cross platform: forge, fabric, quilt

## Geckolib Animation Managers

