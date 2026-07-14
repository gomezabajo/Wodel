<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="pathwithlazyrule"/>
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
		<constant value="A.__matchaRuleWithFilter():V"/>
		<constant value="__exec__"/>
		<constant value="model"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applymodel(NTransientLink;):V"/>
		<constant value="aRuleWithFilter"/>
		<constant value="A.__applyaRuleWithFilter(NTransientLink;):V"/>
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
		<constant value="J.oclIsKindOf(J):J"/>
		<constant value="B.not():B"/>
		<constant value="32"/>
		<constant value="CJ.including(J):CJ"/>
		<constant value="5"/>
		<constant value="J.convertA(J):J"/>
		<constant value="9:14-9:23"/>
		<constant value="9:6-9:23"/>
		<constant value="10:46-10:49"/>
		<constant value="10:46-10:58"/>
		<constant value="10:71-10:72"/>
		<constant value="10:85-10:91"/>
		<constant value="10:71-10:92"/>
		<constant value="10:46-10:93"/>
		<constant value="11:18-11:21"/>
		<constant value="11:18-11:30"/>
		<constant value="11:44-11:54"/>
		<constant value="11:64-11:65"/>
		<constant value="11:44-11:66"/>
		<constant value="11:18-11:68"/>
		<constant value="10:18-11:68"/>
		<constant value="10:6-11:68"/>
		<constant value="a"/>
		<constant value="as"/>
		<constant value="link"/>
		<constant value="convertA"/>
		<constant value="MABCD!A;"/>
		<constant value="x"/>
		<constant value="X"/>
		<constant value="children"/>
		<constant value="20:12-20:21"/>
		<constant value="20:4-20:21"/>
		<constant value="22:16-22:17"/>
		<constant value="22:16-22:26"/>
		<constant value="22:4-22:26"/>
		<constant value="19:3-23:4"/>
		<constant value="__matchaRuleWithFilter"/>
		<constant value="someName"/>
		<constant value="J.=(J):J"/>
		<constant value="33"/>
		<constant value="28:17-28:18"/>
		<constant value="28:17-28:23"/>
		<constant value="28:26-28:36"/>
		<constant value="28:17-28:36"/>
		<constant value="30:3-32:4"/>
		<constant value="__applyaRuleWithFilter"/>
		<constant value="31:12-31:21"/>
		<constant value="31:4-31:21"/>
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
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="3"/>
		</localvariabletable>
	</operation>
	<operation name="42">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="43"/>
			<call arg="44"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="45"/>
			<enditerate/>
			<getasm/>
			<get arg="1"/>
			<push arg="46"/>
			<call arg="44"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="47"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="1" name="33" begin="15" end="18"/>
			<lve slot="0" name="17" begin="0" end="19"/>
		</localvariabletable>
	</operation>
	<operation name="48">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="49"/>
			<push arg="50"/>
			<findme/>
			<push arg="51"/>
			<call arg="52"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="53"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="43"/>
			<pcall arg="54"/>
			<dup/>
			<push arg="55"/>
			<load arg="19"/>
			<pcall arg="56"/>
			<dup/>
			<push arg="57"/>
			<push arg="49"/>
			<push arg="58"/>
			<new/>
			<pcall arg="59"/>
			<pusht/>
			<pcall arg="60"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="61" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="55" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="62">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="63"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="55"/>
			<call arg="64"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="57"/>
			<call arg="65"/>
			<store arg="66"/>
			<load arg="66"/>
			<dup/>
			<getasm/>
			<push arg="67"/>
			<call arg="30"/>
			<set arg="38"/>
			<dup/>
			<getasm/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="29"/>
			<get arg="68"/>
			<iterate/>
			<store arg="69"/>
			<load arg="69"/>
			<push arg="6"/>
			<push arg="50"/>
			<findme/>
			<call arg="70"/>
			<call arg="71"/>
			<if arg="72"/>
			<load arg="69"/>
			<call arg="73"/>
			<enditerate/>
			<store arg="69"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="29"/>
			<get arg="68"/>
			<iterate/>
			<store arg="74"/>
			<getasm/>
			<load arg="74"/>
			<call arg="75"/>
			<call arg="73"/>
			<enditerate/>
			<call arg="30"/>
			<set arg="68"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="76" begin="11" end="11"/>
			<lne id="77" begin="9" end="13"/>
			<lne id="78" begin="19" end="19"/>
			<lne id="79" begin="19" end="20"/>
			<lne id="80" begin="23" end="23"/>
			<lne id="81" begin="24" end="26"/>
			<lne id="82" begin="23" end="27"/>
			<lne id="83" begin="16" end="32"/>
			<lne id="84" begin="37" end="37"/>
			<lne id="85" begin="37" end="38"/>
			<lne id="86" begin="41" end="41"/>
			<lne id="87" begin="42" end="42"/>
			<lne id="88" begin="41" end="43"/>
			<lne id="89" begin="34" end="45"/>
			<lne id="90" begin="16" end="45"/>
			<lne id="91" begin="14" end="47"/>
			<lne id="61" begin="8" end="48"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="4" name="92" begin="22" end="31"/>
			<lve slot="5" name="92" begin="40" end="44"/>
			<lve slot="4" name="93" begin="33" end="45"/>
			<lve slot="3" name="57" begin="7" end="48"/>
			<lve slot="2" name="55" begin="3" end="48"/>
			<lve slot="0" name="17" begin="0" end="48"/>
			<lve slot="1" name="94" begin="0" end="48"/>
		</localvariabletable>
	</operation>
	<operation name="95">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="96"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="53"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="95"/>
			<pcall arg="54"/>
			<dup/>
			<push arg="92"/>
			<load arg="19"/>
			<pcall arg="56"/>
			<dup/>
			<push arg="97"/>
			<push arg="98"/>
			<push arg="58"/>
			<new/>
			<dup/>
			<store arg="29"/>
			<pcall arg="59"/>
			<pushf/>
			<pcall arg="60"/>
			<load arg="29"/>
			<dup/>
			<getasm/>
			<push arg="67"/>
			<call arg="30"/>
			<set arg="38"/>
			<dup/>
			<getasm/>
			<load arg="19"/>
			<get arg="99"/>
			<call arg="30"/>
			<set arg="99"/>
			<pop/>
			<load arg="29"/>
		</code>
		<linenumbertable>
			<lne id="100" begin="25" end="25"/>
			<lne id="101" begin="23" end="27"/>
			<lne id="102" begin="30" end="30"/>
			<lne id="103" begin="30" end="31"/>
			<lne id="104" begin="28" end="33"/>
			<lne id="105" begin="22" end="34"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="97" begin="18" end="35"/>
			<lve slot="0" name="17" begin="0" end="35"/>
			<lve slot="1" name="92" begin="0" end="35"/>
		</localvariabletable>
	</operation>
	<operation name="106">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="6"/>
			<push arg="50"/>
			<findme/>
			<push arg="51"/>
			<call arg="52"/>
			<iterate/>
			<store arg="19"/>
			<load arg="19"/>
			<get arg="38"/>
			<push arg="107"/>
			<call arg="108"/>
			<call arg="71"/>
			<if arg="109"/>
			<getasm/>
			<get arg="1"/>
			<push arg="53"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="46"/>
			<pcall arg="54"/>
			<dup/>
			<push arg="92"/>
			<load arg="19"/>
			<pcall arg="56"/>
			<dup/>
			<push arg="97"/>
			<push arg="98"/>
			<push arg="58"/>
			<new/>
			<pcall arg="59"/>
			<pusht/>
			<pcall arg="60"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="110" begin="7" end="7"/>
			<lne id="111" begin="7" end="8"/>
			<lne id="112" begin="9" end="9"/>
			<lne id="113" begin="7" end="10"/>
			<lne id="114" begin="25" end="30"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="92" begin="6" end="32"/>
			<lve slot="0" name="17" begin="0" end="33"/>
		</localvariabletable>
	</operation>
	<operation name="115">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="63"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="92"/>
			<call arg="64"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="97"/>
			<call arg="65"/>
			<store arg="66"/>
			<load arg="66"/>
			<dup/>
			<getasm/>
			<push arg="67"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="116" begin="11" end="11"/>
			<lne id="117" begin="9" end="13"/>
			<lne id="114" begin="8" end="14"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="97" begin="7" end="14"/>
			<lve slot="2" name="92" begin="3" end="14"/>
			<lve slot="0" name="17" begin="0" end="14"/>
			<lve slot="1" name="94" begin="0" end="14"/>
		</localvariabletable>
	</operation>
</asm>
