#!/bin/bash
# This script deploys to the webpoker.info website
#   $1 = the group  "group1"
group=$1
targetdir="fa2022/$1"
# Where $targetdir is probably either
#    group0
#    group1
#    group2
#    group3
# just to be sure, let's check
if [[ $group =~ group? ]]; then
   echo "Copying into ${targetdir} on webpoker.info"
   scp -r */ * fa2022_$group@webpoker.info:.
   echo "Copy complete."
   echo "Enter the password for $group on webpoker.info to install"
   ssh fa2022_$group@webpoker.info bash scripts/restart.bash fa2022_$group
fi
