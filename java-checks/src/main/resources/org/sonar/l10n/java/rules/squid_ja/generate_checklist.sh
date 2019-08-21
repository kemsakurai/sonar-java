#!/bin/sh       

cd ../
diff -rq squid squid_ja | sed 's/Only in squid: /- [ ] /g' \
| sed 's#Files squid/#- [X] #g' | sed -E 's/and .+//g' \
| sed '/generate_checklist.sh/d'
