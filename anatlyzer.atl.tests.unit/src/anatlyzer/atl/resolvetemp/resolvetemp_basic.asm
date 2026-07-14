<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="resolvetempbasic"/>
		<constant value="links"/>
		<constant value="NTransientLinkSet;"/>
		<constant value="col"/>
		<constant value="J"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="OclParametrizedType"/>
		<constant value="#native"/>
		<constant value="Collection"/>
		<constant value="J.setName(S):V"/>
		<constant value="OclSimpleType"/>
		<constant value="OclAny"/>
		<constant value="J.setElementType(J):V"/>
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
		<constant value="self"/>
		<constant value="__resolve__"/>
		<constant value="1"/>
		<constant value="J.oclIsKindOf(J):B"/>
		<constant value="18"/>
		<constant value="NTransientLinkSet;.getLinkBySourceElement(S):QNTransientLink;"/>
		<constant value="J.oclIsUndefined():B"/>
		<constant value="15"/>
		<constant value="NTransientLink;.getTargetFromSource(J):J"/>
		<constant value="17"/>
		<constant value="30"/>
		<constant value="Sequence"/>
		<constant value="2"/>
		<constant value="A.__resolve__(J):J"/>
		<constant value="QJ.including(J):QJ"/>
		<constant value="QJ.flatten():QJ"/>
		<constant value="e"/>
		<constant value="value"/>
		<constant value="resolveTemp"/>
		<constant value="S"/>
		<constant value="NTransientLink;.getNamedTargetFromSource(JS):J"/>
		<constant value="name"/>
		<constant value="__matcher__"/>
		<constant value="A.__matchmodel():V"/>
		<constant value="A.__matcha2a():V"/>
		<constant value="A.__matchother():V"/>
		<constant value="__exec__"/>
		<constant value="model"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applymodel(NTransientLink;):V"/>
		<constant value="a2a"/>
		<constant value="A.__applya2a(NTransientLink;):V"/>
		<constant value="other"/>
		<constant value="A.__applyother(NTransientLink;):V"/>
		<constant value="__matchmodel"/>
		<constant value="Model"/>
		<constant value="ABCD"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="src"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="tgt"/>
		<constant value="WXYZ"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="8:10-12:3"/>
		<constant value="__applymodel"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="default"/>
		<constant value="elements"/>
		<constant value="4"/>
		<constant value="x"/>
		<constant value="J.resolveTemp(JJ):J"/>
		<constant value="CJ.including(J):CJ"/>
		<constant value="others"/>
		<constant value="J.first():J"/>
		<constant value="t"/>
		<constant value="9:14-9:23"/>
		<constant value="9:6-9:23"/>
		<constant value="10:18-10:21"/>
		<constant value="10:18-10:30"/>
		<constant value="10:44-10:54"/>
		<constant value="10:67-10:68"/>
		<constant value="10:70-10:73"/>
		<constant value="10:44-10:74"/>
		<constant value="10:18-10:75"/>
		<constant value="10:6-10:75"/>
		<constant value="11:15-11:25"/>
		<constant value="11:38-11:41"/>
		<constant value="11:38-11:48"/>
		<constant value="11:38-11:57"/>
		<constant value="11:59-11:62"/>
		<constant value="11:15-11:63"/>
		<constant value="11:3-11:63"/>
		<constant value="link"/>
		<constant value="__matcha2a"/>
		<constant value="myA"/>
		<constant value="J.=(J):J"/>
		<constant value="B.not():B"/>
		<constant value="33"/>
		<constant value="a"/>
		<constant value="X"/>
		<constant value="17:16-17:17"/>
		<constant value="17:16-17:22"/>
		<constant value="17:25-17:30"/>
		<constant value="17:16-17:30"/>
		<constant value="19:3-21:4"/>
		<constant value="__applya2a"/>
		<constant value="20:12-20:13"/>
		<constant value="20:12-20:18"/>
		<constant value="20:4-20:18"/>
		<constant value="__matchother"/>
		<constant value="Other"/>
		<constant value="o"/>
		<constant value="28:3-30:4"/>
		<constant value="__applyother"/>
		<constant value="29:12-29:21"/>
		<constant value="29:4-29:21"/>
	</cp>
	<field name="1" type="2"/>
	<field name="3" type="4"/>
	<operation name="5">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<push arg="7"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="9"/>
			<pcall arg="10"/>
			<dup/>
			<push arg="11"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="12"/>
			<pcall arg="10"/>
			<pcall arg="13"/>
			<set arg="3"/>
			<getasm/>
			<push arg="14"/>
			<push arg="8"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<pcall arg="15"/>
			<getasm/>
			<pcall arg="16"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="24"/>
		</localvariabletable>
	</operation>
	<operation name="18">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
		</parameters>
		<code>
			<load arg="19"/>
			<getasm/>
			<get arg="3"/>
			<call arg="20"/>
			<if arg="21"/>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<dup/>
			<call arg="23"/>
			<if arg="24"/>
			<load arg="19"/>
			<call arg="25"/>
			<goto arg="26"/>
			<pop/>
			<load arg="19"/>
			<goto arg="27"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="19"/>
			<iterate/>
			<store arg="29"/>
			<getasm/>
			<load arg="29"/>
			<call arg="30"/>
			<call arg="31"/>
			<enditerate/>
			<call arg="32"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="33" begin="23" end="27"/>
			<lve slot="0" name="17" begin="0" end="29"/>
			<lve slot="1" name="34" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="35">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
			<parameter name="29" type="36"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<load arg="19"/>
			<load arg="29"/>
			<call arg="37"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="6"/>
			<lve slot="1" name="34" begin="0" end="6"/>
			<lve slot="2" name="38" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="39">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<pcall arg="40"/>
			<getasm/>
			<pcall arg="41"/>
			<getasm/>
			<pcall arg="42"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="5"/>
		</localvariabletable>
	</operation>
	<operation name="43">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="44"/>
			<call arg="45"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="46"/>
			<enditerate/>
			<getasm/>
			<get arg="1"/>
			<push arg="47"/>
			<call arg="45"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="48"/>
			<enditerate/>
			<getasm/>
			<get arg="1"/>
			<push arg="49"/>
			<call arg="45"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="50"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="1" name="33" begin="15" end="18"/>
			<lve slot="1" name="33" begin="25" end="28"/>
			<lve slot="0" name="17" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="51">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="52"/>
			<push arg="53"/>
			<findme/>
			<push arg="54"/>
			<call arg="55"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="56"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="44"/>
			<pcall arg="57"/>
			<dup/>
			<push arg="58"/>
			<load arg="19"/>
			<pcall arg="59"/>
			<dup/>
			<push arg="60"/>
			<push arg="52"/>
			<push arg="61"/>
			<new/>
			<pcall arg="62"/>
			<pusht/>
			<pcall arg="63"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="64" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="58" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="65">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="66"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="58"/>
			<call arg="67"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="60"/>
			<call arg="68"/>
			<store arg="69"/>
			<load arg="69"/>
			<dup/>
			<getasm/>
			<push arg="70"/>
			<call arg="30"/>
			<set arg="38"/>
			<dup/>
			<getasm/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="29"/>
			<get arg="71"/>
			<iterate/>
			<store arg="72"/>
			<getasm/>
			<load arg="72"/>
			<push arg="73"/>
			<call arg="74"/>
			<call arg="75"/>
			<enditerate/>
			<call arg="30"/>
			<set arg="71"/>
			<dup/>
			<getasm/>
			<getasm/>
			<load arg="29"/>
			<get arg="76"/>
			<call arg="77"/>
			<push arg="78"/>
			<call arg="74"/>
			<call arg="30"/>
			<set arg="76"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="79" begin="11" end="11"/>
			<lne id="80" begin="9" end="13"/>
			<lne id="81" begin="19" end="19"/>
			<lne id="82" begin="19" end="20"/>
			<lne id="83" begin="23" end="23"/>
			<lne id="84" begin="24" end="24"/>
			<lne id="85" begin="25" end="25"/>
			<lne id="86" begin="23" end="26"/>
			<lne id="87" begin="16" end="28"/>
			<lne id="88" begin="14" end="30"/>
			<lne id="89" begin="33" end="33"/>
			<lne id="90" begin="34" end="34"/>
			<lne id="91" begin="34" end="35"/>
			<lne id="92" begin="34" end="36"/>
			<lne id="93" begin="37" end="37"/>
			<lne id="94" begin="33" end="38"/>
			<lne id="95" begin="31" end="40"/>
			<lne id="64" begin="8" end="41"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="4" name="33" begin="22" end="27"/>
			<lve slot="3" name="60" begin="7" end="41"/>
			<lve slot="2" name="58" begin="3" end="41"/>
			<lve slot="0" name="17" begin="0" end="41"/>
			<lve slot="1" name="96" begin="0" end="41"/>
		</localvariabletable>
	</operation>
	<operation name="97">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="6"/>
			<push arg="53"/>
			<findme/>
			<push arg="54"/>
			<call arg="55"/>
			<iterate/>
			<store arg="19"/>
			<load arg="19"/>
			<get arg="38"/>
			<push arg="98"/>
			<call arg="99"/>
			<call arg="100"/>
			<if arg="101"/>
			<getasm/>
			<get arg="1"/>
			<push arg="56"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="47"/>
			<pcall arg="57"/>
			<dup/>
			<push arg="102"/>
			<load arg="19"/>
			<pcall arg="59"/>
			<dup/>
			<push arg="73"/>
			<push arg="103"/>
			<push arg="61"/>
			<new/>
			<pcall arg="62"/>
			<pusht/>
			<pcall arg="63"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="104" begin="7" end="7"/>
			<lne id="105" begin="7" end="8"/>
			<lne id="106" begin="9" end="9"/>
			<lne id="107" begin="7" end="10"/>
			<lne id="108" begin="25" end="30"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="102" begin="6" end="32"/>
			<lve slot="0" name="17" begin="0" end="33"/>
		</localvariabletable>
	</operation>
	<operation name="109">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="66"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="102"/>
			<call arg="67"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="73"/>
			<call arg="68"/>
			<store arg="69"/>
			<load arg="69"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="110" begin="11" end="11"/>
			<lne id="111" begin="11" end="12"/>
			<lne id="112" begin="9" end="14"/>
			<lne id="108" begin="8" end="15"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="73" begin="7" end="15"/>
			<lve slot="2" name="102" begin="3" end="15"/>
			<lve slot="0" name="17" begin="0" end="15"/>
			<lve slot="1" name="96" begin="0" end="15"/>
		</localvariabletable>
	</operation>
	<operation name="113">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="114"/>
			<push arg="53"/>
			<findme/>
			<push arg="54"/>
			<call arg="55"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="56"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="49"/>
			<pcall arg="57"/>
			<dup/>
			<push arg="115"/>
			<load arg="19"/>
			<pcall arg="59"/>
			<dup/>
			<push arg="78"/>
			<push arg="114"/>
			<push arg="61"/>
			<new/>
			<pcall arg="62"/>
			<pusht/>
			<pcall arg="63"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="116" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="115" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="117">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="66"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="115"/>
			<call arg="67"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="78"/>
			<call arg="68"/>
			<store arg="69"/>
			<load arg="69"/>
			<dup/>
			<getasm/>
			<push arg="70"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="118" begin="11" end="11"/>
			<lne id="119" begin="9" end="13"/>
			<lne id="116" begin="8" end="14"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="78" begin="7" end="14"/>
			<lve slot="2" name="115" begin="3" end="14"/>
			<lve slot="0" name="17" begin="0" end="14"/>
			<lve slot="1" name="96" begin="0" end="14"/>
		</localvariabletable>
	</operation>
</asm>
