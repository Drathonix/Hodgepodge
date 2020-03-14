# A Hodgepodge of Fixes

## Fixes:
* RandomPositionGenerator - Backports removal of the North/West bias
* FixGrassChunkLoads - Stops grass tick/spread from loading chunks
* FixFenceConnections - Tweaks fence connection logic to work with other mods
* FixIc2DirectInventoryAccess - Swaps out direct inventory access in crop functions with `setInventorySlotContents` so they work with OC robots

## Running


If running in dev add the following Program arguments: 
```
--tweakClass org.spongepowered.asm.launch.MixinTweaker --mixin mixins.hodgepodge.json
```
