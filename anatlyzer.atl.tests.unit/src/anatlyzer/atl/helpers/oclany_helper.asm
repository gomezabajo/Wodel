<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="oclanyhelper"/>
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
		<constant value="aHelper"/>
		<constant value="__initaHelper"/>
		<constant value="J.registerHelperAttribute(SS):V"/>
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
		<constant value="4:16-4:22"/>
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
		<constant value="aValue"/>
		<constant value="4:47-4:55"/>
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
		<constant value="11:10-13:3"/>
		<constant value="__applymodel"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="test"/>
		<constant value="J.+(J):J"/>
		<constant value="12:14-12:20"/>
		<constant value="12:14-12:28"/>
		<constant value="12:31-12:34"/>
		<constant value="12:31-12:42"/>
		<constant value="12:14-12:42"/>
		<constant value="12:6-12:42"/>
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
			<push arg="12"/>
			<push arg="8"/>
			<findme/>
			<push arg="14"/>
			<push arg="15"/>
			<pcall arg="16"/>
			<getasm/>
			<push arg="17"/>
			<push arg="8"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<pcall arg="18"/>
			<getasm/>
			<pcall arg="19"/>
		</code>
		<linenumbertable>
			<lne id="20" begin="16" end="18"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="21" begin="0" end="30"/>
		</localvariabletable>
	</operation>
	<operation name="22">
		<context type="6"/>
		<parameters>
			<parameter name="23" type="4"/>
		</parameters>
		<code>
			<load arg="23"/>
			<getasm/>
			<get arg="3"/>
			<call arg="24"/>
			<if arg="25"/>
			<getasm/>
			<get arg="1"/>
			<load arg="23"/>
			<call arg="26"/>
			<dup/>
			<call arg="27"/>
			<if arg="28"/>
			<load arg="23"/>
			<call arg="29"/>
			<goto arg="30"/>
			<pop/>
			<load arg="23"/>
			<goto arg="31"/>
			<push arg="32"/>
			<push arg="8"/>
			<new/>
			<load arg="23"/>
			<iterate/>
			<store arg="33"/>
			<getasm/>
			<load arg="33"/>
			<call arg="34"/>
			<call arg="35"/>
			<enditerate/>
			<call arg="36"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="37" begin="23" end="27"/>
			<lve slot="0" name="21" begin="0" end="29"/>
			<lve slot="1" name="38" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="39">
		<context type="6"/>
		<parameters>
			<parameter name="23" type="4"/>
			<parameter name="33" type="40"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="23"/>
			<call arg="26"/>
			<load arg="23"/>
			<load arg="33"/>
			<call arg="41"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="21" begin="0" end="6"/>
			<lve slot="1" name="38" begin="0" end="6"/>
			<lve slot="2" name="42" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="43">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<pcall arg="44"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="21" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="45">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="46"/>
			<call arg="47"/>
			<iterate/>
			<store arg="23"/>
			<getasm/>
			<load arg="23"/>
			<pcall arg="48"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="37" begin="5" end="8"/>
			<lve slot="0" name="21" begin="0" end="9"/>
		</localvariabletable>
	</operation>
	<operation name="15">
		<context type="4"/>
		<parameters>
		</parameters>
		<code>
			<push arg="49"/>
		</code>
		<linenumbertable>
			<lne id="50" begin="0" end="0"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="21" begin="0" end="0"/>
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
			<store arg="23"/>
			<getasm/>
			<get arg="1"/>
			<push arg="56"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="46"/>
			<pcall arg="57"/>
			<dup/>
			<push arg="58"/>
			<load arg="23"/>
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
			<lve slot="0" name="21" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="65">
		<context type="6"/>
		<parameters>
			<parameter name="23" type="66"/>
		</parameters>
		<code>
			<load arg="23"/>
			<push arg="58"/>
			<call arg="67"/>
			<store arg="33"/>
			<load arg="23"/>
			<push arg="60"/>
			<call arg="68"/>
			<store arg="69"/>
			<load arg="69"/>
			<dup/>
			<getasm/>
			<push arg="70"/>
			<get arg="14"/>
			<load arg="33"/>
			<get arg="14"/>
			<call arg="71"/>
			<call arg="34"/>
			<set arg="42"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="72" begin="11" end="11"/>
			<lne id="73" begin="11" end="12"/>
			<lne id="74" begin="13" end="13"/>
			<lne id="75" begin="13" end="14"/>
			<lne id="76" begin="11" end="15"/>
			<lne id="77" begin="9" end="17"/>
			<lne id="64" begin="8" end="18"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="60" begin="7" end="18"/>
			<lve slot="2" name="58" begin="3" end="18"/>
			<lve slot="0" name="21" begin="0" end="18"/>
			<lve slot="1" name="78" begin="0" end="18"/>
		</localvariabletable>
	</operation>
</asm>
