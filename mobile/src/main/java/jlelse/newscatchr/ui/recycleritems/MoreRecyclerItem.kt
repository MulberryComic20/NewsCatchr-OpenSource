/*
 * NewsCatchr  Copyright (C) 2016  Jan-Lukas Else
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package jlelse.newscatchr.ui.recycleritems

import android.support.annotation.Keep
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import com.mcxiaoke.koi.ext.find
import com.mcxiaoke.koi.ext.onClick
import com.mikepenz.fastadapter.items.AbstractItem
import com.mikepenz.fastadapter.utils.ViewHolderFactory
import jlelse.readit.R


@Keep
class MoreRecyclerItem : AbstractItem<MoreRecyclerItem, MoreRecyclerItem.ViewHolder>() {
	private val FACTORY = ItemFactory()

	private var callback: () -> Unit = {}

	fun withCallback(callback: () -> Unit): MoreRecyclerItem {
		this.callback = callback
		return this
	}

	override fun getType(): Int {
		return R.id.more_item_id
	}

	override fun getLayoutRes(): Int {
		return R.layout.recyclershowmoreitem
	}

	override fun bindView(viewHolder: ViewHolder, payloads: MutableList<Any?>?) {
		super.bindView(viewHolder, payloads)
		viewHolder.button.onClick { callback() }
	}

	override fun getFactory(): ViewHolderFactory<out ViewHolder> = FACTORY

	class ItemFactory : ViewHolderFactory<ViewHolder> {
		override fun create(v: View): ViewHolder {
			return ViewHolder(v)
		}
	}

	class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
		var button: Button

		init {
			this.button = view.find<Button>(R.id.moreButton)
		}
	}
}