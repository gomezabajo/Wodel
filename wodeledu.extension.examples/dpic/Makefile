# The default postprocessor can be changed automatically as described below.
# This default can be overridden by reading the appropriate configuration file
# as the first file read by m4.

# Some of the steps could be simplified on many systems.

default:
	@echo "Usage:"
	@echo "  make psdefault"
	@echo "  make pgfdefault"
	@echo "  make gpicdefault"
	@echo "  make clean"
	@echo "  make clobber"

SH = sh
# SH = bash

#                                 To set the default postprocessor to
#                                 dpic -p with pstricks, type "make psdefault"
psdefault:
	@sed -e '/m4picprocessor/s/include([a-z][a-z]*\.m4)/include(pstricks.m4)/' \
      libgen.m4 > tmplibgen
	mv tmplibgen libgen.m4; chmod 644 libgen.m4
	@grep 'include.*divert' libgen.m4

#                                 To set the default postprocessor to
#                                 dpic -g with TikZ PGF, type "make pgfdefault"
pgfdefault:
	@sed -e '/m4picprocessor/s/include([a-z][a-z]*\.m4)/include(pgf.m4)/' \
      libgen.m4 > tmplibgen
	mv tmplibgen libgen.m4; chmod 644 libgen.m4
	@grep 'include.*divert' libgen.m4

#                                 To set the default postprocessor to
#                                 gpic -t type "make gpicdefault"
gpicdefault:
	@sed -e '/m4picprocessor/s/include([a-z][a-z]*\.m4)/include(gpic.m4)/' \
      libgen.m4 > tmplibgen
	mv tmplibgen libgen.m4; chmod 644 libgen.m4
	@grep 'include.*divert' libgen.m4

clean:
	rm -f `find . -name \*~ -print` tmplibgen
	(cd doc; make clean)
	(cd examples; make clean)

clobber:
	rm -f `find . -name \*~ -print`
	(cd doc; make clobber)
	(cd examples; make clobber)
