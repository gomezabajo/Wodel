<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="bindingassingment"/>
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
		<constant value="__exec__"/>
		<constant value="model"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applymodel(NTransientLink;):V"/>
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
		<constant value="x1"/>
		<constant value="X"/>
		<constant value="x2"/>
		<constant value="other"/>
		<constant value="Other"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="8:10-10:3"/>
		<constant value="10:5-12:3"/>
		<constant value="12:5-14:3"/>
		<constant value="14:5-16:3"/>
		<constant value="__applymodel"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="4"/>
		<constant value="5"/>
		<constant value="6"/>
		<constant value="default"/>
		<constant value="anX1"/>
		<constant value="anX2"/>
		<constant value="CJ.including(J):CJ"/>
		<constant value="optionalX"/>
		<constant value="elements"/>
		<constant value="9:14-9:23"/>
		<constant value="9:6-9:23"/>
		<constant value="11:11-11:17"/>
		<constant value="11:3-11:17"/>
		<constant value="13:11-13:17"/>
		<constant value="13:3-13:17"/>
		<constant value="15:11-15:18"/>
		<constant value="15:3-15:18"/>
		<constant value="18:3-18:6"/>
		<constant value="18:31-18:33"/>
		<constant value="18:35-18:37"/>
		<constant value="18:20-18:39"/>
		<constant value="18:3-18:40"/>
		<constant value="19:3-19:6"/>
		<constant value="19:19-19:21"/>
		<constant value="19:3-19:22"/>
		<constant value="20:3-20:6"/>
		<constant value="20:19-20:21"/>
		<constant value="20:3-20:22"/>
		<constant value="21:3-21:6"/>
		<constant value="21:19-21:24"/>
		<constant value="21:3-21:25"/>
		<constant value="17:2-22:3"/>
		<constant value="link"/>
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
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="41">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="42"/>
			<call arg="43"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="44"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="0" name="17" begin="0" end="9"/>
		</localvariabletable>
	</operation>
	<operation name="45">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="46"/>
			<push arg="47"/>
			<findme/>
			<push arg="48"/>
			<call arg="49"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="50"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="42"/>
			<pcall arg="51"/>
			<dup/>
			<push arg="52"/>
			<load arg="19"/>
			<pcall arg="53"/>
			<dup/>
			<push arg="54"/>
			<push arg="46"/>
			<push arg="55"/>
			<new/>
			<pcall arg="56"/>
			<dup/>
			<push arg="57"/>
			<push arg="58"/>
			<push arg="55"/>
			<new/>
			<pcall arg="56"/>
			<dup/>
			<push arg="59"/>
			<push arg="58"/>
			<push arg="55"/>
			<new/>
			<pcall arg="56"/>
			<dup/>
			<push arg="60"/>
			<push arg="61"/>
			<push arg="55"/>
			<new/>
			<pcall arg="56"/>
			<pusht/>
			<pcall arg="62"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="63" begin="19" end="24"/>
			<lne id="64" begin="25" end="30"/>
			<lne id="65" begin="31" end="36"/>
			<lne id="66" begin="37" end="42"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="52" begin="6" end="44"/>
			<lve slot="0" name="17" begin="0" end="45"/>
		</localvariabletable>
	</operation>
	<operation name="67">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="68"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="52"/>
			<call arg="69"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="54"/>
			<call arg="70"/>
			<store arg="71"/>
			<load arg="19"/>
			<push arg="57"/>
			<call arg="70"/>
			<store arg="72"/>
			<load arg="19"/>
			<push arg="59"/>
			<call arg="70"/>
			<store arg="73"/>
			<load arg="19"/>
			<push arg="60"/>
			<call arg="70"/>
			<store arg="74"/>
			<load arg="71"/>
			<dup/>
			<getasm/>
			<push arg="75"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
			<load arg="72"/>
			<dup/>
			<getasm/>
			<push arg="76"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
			<load arg="73"/>
			<dup/>
			<getasm/>
			<push arg="77"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
			<load arg="74"/>
			<dup/>
			<getasm/>
			<push arg="60"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
			<load arg="71"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="72"/>
			<call arg="78"/>
			<load arg="73"/>
			<call arg="78"/>
			<set arg="79"/>
			<load arg="71"/>
			<load arg="72"/>
			<set arg="80"/>
			<load arg="71"/>
			<load arg="73"/>
			<set arg="80"/>
			<load arg="71"/>
			<load arg="74"/>
			<set arg="80"/>
		</code>
		<linenumbertable>
			<lne id="81" begin="23" end="23"/>
			<lne id="82" begin="21" end="25"/>
			<lne id="63" begin="20" end="26"/>
			<lne id="83" begin="30" end="30"/>
			<lne id="84" begin="28" end="32"/>
			<lne id="64" begin="27" end="33"/>
			<lne id="85" begin="37" end="37"/>
			<lne id="86" begin="35" end="39"/>
			<lne id="65" begin="34" end="40"/>
			<lne id="87" begin="44" end="44"/>
			<lne id="88" begin="42" end="46"/>
			<lne id="66" begin="41" end="47"/>
			<lne id="89" begin="48" end="48"/>
			<lne id="90" begin="52" end="52"/>
			<lne id="91" begin="54" end="54"/>
			<lne id="92" begin="49" end="55"/>
			<lne id="93" begin="48" end="56"/>
			<lne id="94" begin="57" end="57"/>
			<lne id="95" begin="58" end="58"/>
			<lne id="96" begin="57" end="59"/>
			<lne id="97" begin="60" end="60"/>
			<lne id="98" begin="61" end="61"/>
			<lne id="99" begin="60" end="62"/>
			<lne id="100" begin="63" end="63"/>
			<lne id="101" begin="64" end="64"/>
			<lne id="102" begin="63" end="65"/>
			<lne id="103" begin="48" end="65"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="54" begin="7" end="65"/>
			<lve slot="4" name="57" begin="11" end="65"/>
			<lve slot="5" name="59" begin="15" end="65"/>
			<lve slot="6" name="60" begin="19" end="65"/>
			<lve slot="2" name="52" begin="3" end="65"/>
			<lve slot="0" name="17" begin="0" end="65"/>
			<lve slot="1" name="104" begin="0" end="65"/>
		</localvariabletable>
	</operation>
</asm>
